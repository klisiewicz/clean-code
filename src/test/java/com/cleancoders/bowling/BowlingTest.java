package com.cleancoders.bowling;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BowlingTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void gutterGame() {
        rollMany(20, 0);
        assertThat(game.getScore(), is(0));
    }

    @Test
    public void allOnes() {
        rollMany(20, 1);
        assertThat(game.getScore(), is(20));
    }

    @Ignore
    @Test
    public void oneSpare() {
        game.roll(5);
        game.roll(5); // Spare
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.getScore(), is(16));
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }
}
