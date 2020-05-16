package com.cleancoders.word;

public final class WordWrapper {
    public String wrap(String input, int length) {
        if (input == null) return "";
        if (input.length() <= length) {
            return input;
        } else {
            int breakPoint = input.lastIndexOf(" ", length);
            if (breakPoint == -1)
                breakPoint = length;
            return input.substring(0, breakPoint) + "\n" + wrap(input.substring(breakPoint).trim(), length);
        }
    }
}
