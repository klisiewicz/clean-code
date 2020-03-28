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
        convergesAtIteration(19, 2);
    }

    private void convergesAtIteration(int n, int iteration) {
        assertThat(Lychrel.convergesAtIteration(n, LIMIT), is(iteration));
    }

    @Test
    public void palindromes() {
        isPalindrome(1);
        isPalindrome(11);
        isPalindrome(121);
        isPalindrome(12321);
        isPalindrome(1234321);
    }

    private void isPalindrome(int n) {
        assertThat(Lychrel.isPalindrome(n), is(true));
    }

    @Test
    public void notPalindromes() {
        isNotPalindrome(10);
        isNotPalindrome(12331);
        isNotPalindrome(1243321);
    }

    private void isNotPalindrome(int n) {
        assertThat(Lychrel.isPalindrome(n), is(false));
    }

    @Test
    public void reverse() {
        reversed();
    }

    private void reversed() {
        reversed(1, 1);
        reversed(12, 21);
        reversed(123, 321);
    }

    private void reversed(int n, int r) {
        assertThat(Lychrel.reverse(n), is(r));
    }
}