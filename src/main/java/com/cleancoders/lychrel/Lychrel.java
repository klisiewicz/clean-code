package com.cleancoders.lychrel;

public class Lychrel {
    public static int convergesAtIteration(int n, int limit) {
        if (isPalindrome(n))
            return 0;
        else
            return 1;
    }

    static boolean isPalindrome(int n) {
        final String digits = Integer.toString(n);
        return digits.charAt(0) == digits.charAt(digits.length() - 1);
    }
}
