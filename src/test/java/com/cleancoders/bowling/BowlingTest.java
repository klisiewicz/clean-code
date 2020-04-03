package com.cleancoders.bowling;

import org.junit.Before;
import org.junit.Test;

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
}
