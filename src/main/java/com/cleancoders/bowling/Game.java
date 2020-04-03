package com.cleancoders.bowling;

public class Game {
    private int score = 0;

    public void roll(int pins) {
        score += pins;
    }

    public int getScore() {
        return score;
    }
}
