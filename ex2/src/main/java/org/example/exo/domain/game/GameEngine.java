package org.example.exo.domain.game;


import org.example.exo.domain.entity.Player;
import org.example.exo.domain.interfaces.Engine;
import org.example.exo.domain.interfaces.Logger;
import org.example.exo.domain.enums.Type;
import org.example.exo.domain.interfaces.Parser;

public final class GameEngine implements Engine {
    private final Parser parser;
    private final Logger logger;
    private final Player player;
    private boolean continuePlaying;


    private GameEngine(Parser parser, boolean continuePlaying, Logger logger, Player player){
        this.parser = parser;
        this.continuePlaying = continuePlaying;
        this.logger = logger;
        this.player = player;
    }

    public static GameEngine instantiate(Parser parser, Logger logger, Player player) {
        return new GameEngine(parser, true, logger, player);
    }

    @Override
    public void play() {
        logger.println("-===========================-", Type.USER);
        logger.println("=== GUESS THE NUMBER GAME ===", Type.USER);
        logger.println("-===========================-", Type.USER);

        while(continuePlaying) {
            logger.println("Guess the number (between 1 and 100)!", Type.USER);
            logger.println("the expected number is " + player.getNumber(), Type.DEBUG);

            getNextHit();

            if (player.getNumber() != player.getUserGuess()) {
                logger.println("You lose after " + player.getMaxAttempts() + " tries, the expected number was " + player.getNumber(), Type.USER);
            }

            logger.println("----------------------------------------------------", Type.USER);
            logger.println("Do you want to try again with a new number (yes/no)?", Type.USER);
            String userResponse = parser.input().trim().toLowerCase();
            continuePlaying = userResponse.equals("yes");
            if (continuePlaying) {
                player.setUserGuess(0);
                player.setAttempts(0);
            }
        }
    }

    private void getNextHit() {
        while (player.getNumber() != player.getUserGuess() && player.getAttempts() < player.getMaxAttempts()) {
            String input = parser.input();
            player.addAttempt();
            try {
                player.setUserGuess(Integer.parseInt(input));
                if (player.getUserGuess() == player.getNumber()) {
                    logger.println("You found it after " + player.getAttempts() + " tries!", Type.USER);
                } else {
                    String divergence = player.getDivergence();
                    logger.println("Wrong! Your number is " + divergence + " than the correct one. " + (player.getMaxAttempts()-player.getAttempts()) + "/" + player.getMaxAttempts() + " tries left", Type.USER);
                }
            } catch (NumberFormatException e) {
                logger.println("Your input was '" + input + "', please enter a valid integer. " + (player.getMaxAttempts()-player.getAttempts()) + "/" + player.getMaxAttempts() + " tries left", Type.USER);
            }
        }
    }

}
