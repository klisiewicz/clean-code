package com.cleancoders.word;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WordWrapperTest {
    @Test
    public void shouldWrap() {
        assertThat(wrap(null, 1), is(""));
        assertThat(wrap("", 1), is(""));
    }

    private String wrap(String input, int lenght) {
        return "";
    }
}
