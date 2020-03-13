package com.cleancoders.primes;

public class PrimePrinter {
    private static final int NUMBER_OF_PRIMES = 1000;
    public static void main(String[] args) {
        final PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();
        int[] primes = primePrinterHelper.generatePrimes();
        primePrinterHelper.printNumbers(primes, NUMBER_OF_PRIMES);
    }
}

class PrimePrinterHelper {
    private final int numberOfPrimes = 1000;
    private final int linesPerPage = 50;
    private final int columns = 4;
    private final int ordMax = 30;
    private final int[] primes = new int[numberOfPrimes + 1];
    private int pageNumber;
    private int pageOffset;
    private int rowOffset;
    private int column;
    private int candicate;
    private int primeIndex;
    private boolean possiblyPrime;
    private int ord;
    private int square;
    private int n;
    private final int[] multiples = new int[ordMax + 1];

    public int[] generatePrimes() {
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

    public void printNumbers(int[] numbers, int totalNumbers) {
        new NumberPrinter(numbers, totalNumbers, linesPerPage, columns).print();
    }

}
