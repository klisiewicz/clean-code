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
        assertWraps("x xx", 3, "x\nxx");
        assertWraps("four score and seven years ago our fathers brought forth upon this continent",
                7,
                "four\nscore\nand\nseven\nyears\nago our\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt"
        );
    }

    private void assertWraps(String input, int length, String expected) {
        assertThat(new WordWrapper().wrap(input, length), is(expected));
    }
}
