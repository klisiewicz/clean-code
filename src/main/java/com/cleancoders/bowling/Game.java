package com.cleancoders.bowling;

public class Game {
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int getScore() {
        int score = 0;
        int firstInFrame = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (rolls[firstInFrame] == 10) {
                // Strike
                score += 10 + rolls[firstInFrame + 1] + rolls[firstInFrame + 2];
                firstInFrame += 1;
            } else if (isSpare(firstInFrame)) {
                score += 10 + rolls[firstInFrame + 2];
                firstInFrame += 2;
            } else {
                score += rolls[firstInFrame] + rolls[firstInFrame + 1];
                firstInFrame += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1] == 10;
    }
}
