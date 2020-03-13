package com.cleancoders.primes;

public class PrimePrinter {
    private static final int NUMBER_OF_PRIMES = 1000;
    private static final int LINES_PER_PAGE = 50;
    private static final int COLUMNS = 4;

    public static void main(String[] args) {
        int[] primes = new PrimeGenerator().generatePrimes(NUMBER_OF_PRIMES);
        new NumberPrinter(LINES_PER_PAGE, COLUMNS).print(primes, NUMBER_OF_PRIMES);
    }
}
