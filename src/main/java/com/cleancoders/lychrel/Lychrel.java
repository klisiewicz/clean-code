package com.cleancoders.lychrel;

import java.math.BigInteger;

public class Lychrel {
    private final int limit;

    public Lychrel(int limit) {
        this.limit = limit;
    }

    public int convergesAtIteration(int n) {
        int iteration = 0;
        return converge(BigInteger.valueOf(n), iteration);
    }

    private int converge(BigInteger n, int iteration) {
        if (!isPalindrome(n) && iteration < limit)
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

    static BigInteger reverse(BigInteger n) {
        final char[] nDigits = n.toString().toCharArray();
        final char[] rDigits = new char[nDigits.length];
        final int lastIndex = nDigits.length - 1;

        for (int i = 0; i < nDigits.length; i++)
            rDigits[i] = nDigits[lastIndex - i];

        return new BigInteger(new String(rDigits));
    }
}
