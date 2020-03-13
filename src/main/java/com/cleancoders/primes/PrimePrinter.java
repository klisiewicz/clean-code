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

class PrimeGenerator {
    private int[] primes;
    private final int ordMax = 30;
    private int candicate;
    private int primeIndex;
    private boolean possiblyPrime;
    private int ord;
    private int square;
    private int n;
    private final int[] multiples = new int[ordMax + 1];

    public int[] generatePrimes(int numberOfPrimes) {
        primes = new int[numberOfPrimes + 1];
        candicate = 1;
        primeIndex = 1;
        primes[1] = 2;
        ord = 2;
        square = 9;

        while (primeIndex < numberOfPrimes) {
            do {
                candicate = candicate + 2;
                if (candicate == square) {
                    ord = ord + 1;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = candicate;
                }
                n = 2;
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n] < candicate)
                        multiples[n] = multiples[n] + primes[n] + primes[n];
                    if (multiples[n] == candicate)
                        possiblyPrime = false;
                    n = n + 1;
                }
            } while (!possiblyPrime);
            primeIndex = primeIndex + 1;
            primes[primeIndex] = candicate;
        }
        return primes;
    }
}
