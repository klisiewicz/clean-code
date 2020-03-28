package com.cleancoders.lychrel;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LychrelTest {
    @Test
    public void facts() {
        isNotLychrel(1, 0, 1000);
    }

    private void isNotLychrel(int n, int iteration, int limit) {
        assertThat(Lychrel.convergesAtIteration(n, limit), is(iteration));
    }
}
