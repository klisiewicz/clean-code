package com.cleancoders.bowling;

import org.junit.Before;
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
    public void canRoll() {
        game.roll(0);
    }

    @Test
    public void gutterGame() {
        for (int i = 0; i < 20; i++)
            game.roll(0);
        assertThat(game.getScore(), is(0));
    }

    @Test
    public void allOnes() {
        for (int i = 0; i < 20; i++)
            game.roll(1);
        assertThat(game.getScore(), is(20));
    }
}
