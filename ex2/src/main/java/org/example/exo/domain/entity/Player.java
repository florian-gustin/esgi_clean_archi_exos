package org.example.exo.domain.entity;

import java.util.Random;

public final class Player {

    private final int maxAttempts;
    private int userGuess;
    private int attempts;
    private int number;

    public Player(int maxAttempts, int userGuess, int attempts) {
        this.maxAttempts = maxAttempts;
        this.userGuess = userGuess;
        this.attempts = attempts;
        this.number = new Random().nextInt(100) + 1;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public int getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(int userGuess) {
        this.userGuess = userGuess;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getNumber() {
        return number;
    }

    public void addAttempt() {
        this.attempts++;
    }

    public String getDivergence() {
        return userGuess < number ? "smaller" : "greater";
    }

}
