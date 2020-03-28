package com.cleancoders.lychrel;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LychrelTest {
    private static final int LIMIT = 1000;

    @Test
    public void facts() {
        convergesAtIteration(1, 0);
        convergesAtIteration(2, 0);
        convergesAtIteration(10, 1);
        convergesAtIteration(11, 0);
    }

    private void convergesAtIteration(int n, int iteration) {
        assertThat(Lychrel.convergesAtIteration(n, LIMIT), is(iteration));
    }

    @Test
    public void palindromes() {
        isPalindrome(1);
        isPalindrome(11);
        isPalindrome(121);
    }

    private void isPalindrome(int n) {
        assertThat(Lychrel.isPalindrome(n), is(true));
    }
}
