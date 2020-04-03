package com.cleancoders.bowling;

import org.junit.Test;

public class BowlingTest {
    @Test
    public void canCreateGame() {
        Game game = new Game();
    }

    @Test
    public void canRoll() {
        Game game = new Game();
        game.roll(0);
    }
}
