package com.cleancoders.lychrel;

import java.math.BigInteger;

public class Lychrel {
    private final int limit;

    public Lychrel(int limit) {
        this.limit = limit;
    }

    static boolean isNotPalindrome(BigInteger n) {
        return !isPalindrome(n);
    }

    public int convergesAtIteration(int n) {
        return converge(BigInteger.valueOf(n), 0);
    }

    private int converge(BigInteger n, int iteration) {
        if (isNotPalindrome(n) && hasNotReachedLimit(iteration))
            return converge(n.add(reverse(n)), ++iteration);
        else
            return iteration;
    }

    static boolean isPalindrome(BigInteger n) {
        final String digits = n.toString();
        final int lastIndex = digits.length() - 1;

        for (int i = 0; i < digits.length(); i++)
            if (digits.charAt(i) != digits.charAt(lastIndex - i))
                return false;

        return true;
    }

    private boolean hasNotReachedLimit(int iteration) {
        return iteration < limit;
    }

    static BigInteger reverse(BigInteger n) {
        final char[] nDigits = n.toString().toCharArray();
        final char[] rDigits = new char[nDigits.length];
        final int lastIndex = nDigits.length - 1;

        for (int i = 0; i < nDigits.length; i++)
            rDigits[i] = nDigits[lastIndex - i];

        return new BigInteger(new String(rDigits));
    }
}
