package org.example;

import org.example.exo.domain.entity.Player;
import org.example.exo.domain.game.GameEngine;
import org.example.exo.infrastructure.logger.ConsoleLogger;
import org.example.exo.infrastructure.parser.ConsoleParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GameEngine.instantiate(
                ConsoleParser.instantiate(),
                ConsoleLogger.instantiate(),
                new Player(10, 0, 0))
                .play();
    }
}
