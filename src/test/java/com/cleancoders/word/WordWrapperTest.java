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
        assertWraps("xx", 1, "x\nx");
        assertWraps("xxx", 1, "x\nx\nx");
        assertWraps("x x", 1, "x\nx");
    }

    private void assertWraps(String input, int length, String expected) {
        assertThat(wrap(input, length), is(expected));
    }

    private String wrap(String input, int lenght) {
        if (input == null) return "";
        if (input.length() <= lenght) {
            return input;
        } else {
            return input.substring(0, lenght) + "\n" + wrap(input.substring(lenght).trim(), lenght);
        }
    }
}
