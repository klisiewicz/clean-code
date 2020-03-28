package com.cleancoders.lychrel;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LychrelTest {
    private static final int LIMIT = 1000;

    @Test
    public void facts() {
        isNotLychrel(1, 0);
        isNotLychrel(2, 0);
        isNotLychrel(10, 1);
    }

    private void isNotLychrel(int n, int iteration) {
        assertThat(Lychrel.convergesAtIteration(n, LIMIT), is(iteration));
    }
}
