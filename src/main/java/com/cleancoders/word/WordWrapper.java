package com.cleancoders.word;

public final class WordWrapper {
    public String wrap(String input, int length) {
        if (input == null) return "";
        return (isShorterThanLength(input, length)) ? input : wrapWithBrakingPoint(input, length);
    }

    private boolean isShorterThanLength(String input, int length) {
        return input.length() <= length;
    }

    private String wrapWithBrakingPoint(String input, int length) {
        int breakPoint = getBreakPoint(input, length);
        return input.substring(0, breakPoint) + "\n" + wrap(input.substring(breakPoint).trim(), length);
    }

    private int getBreakPoint(String input, int length) {
        int breakPoint = input.lastIndexOf(' ', length);
        return (breakPoint >= 0) ? breakPoint : length;
    }
}
