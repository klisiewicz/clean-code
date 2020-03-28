package com.cleancoders.lychrel;

public class Lychrel {
    public static int convergesAtIteration(int n, int limit) {
        if (!isPalindrome(n)) {
            final int r = reverse(n);
            final int sum = r + n;
            if (!isPalindrome(sum))
                return 2;
            else
                return 1;
        } else {
            return 0;
        }
    }

    static boolean isPalindrome(int n) {
        final String digits = Integer.toString(n);
        final int lastIndex = digits.length() - 1;

        for (int i = 0; i < digits.length(); i++)
            if (digits.charAt(i) != digits.charAt(lastIndex - i))
                return false;

        return true;
    }

    static int reverse(int n) {
        final char[] nDigits = Integer.toString(n).toCharArray();
        final char[] rDigits = new char[nDigits.length];
        final int lastIndex = nDigits.length - 1;

        for (int i = 0; i < nDigits.length; i++)
            rDigits[i] = nDigits[lastIndex - i];

        return Integer.parseInt(new String(rDigits));
    }
}