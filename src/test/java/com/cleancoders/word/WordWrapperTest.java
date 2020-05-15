package com.cleancoders.word;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WordWrapperTest {
    @Test
    public void shouldWrap() {
        assertWraps(null, 1, "");
        assertWraps("", 1, "");
        assertWraps("x", 1, "x");
    }

    private void assertWraps(String input, int length, String expected) {
        assertThat(wrap(input, length), is(expected));
    }

    private String wrap(String input, int lenght) {
        return input == null ? "" : input;
    }
}
