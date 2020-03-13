package com.cleancoders.primes;

class NumberPrinter {
    private final int linesPerPage;
    private final int columns;

    public NumberPrinter(int linesPerPage, int columns) {
        this.linesPerPage = linesPerPage;
        this.columns = columns;
    }

    public void print(int[] numbers, int totalNumbers) {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= totalNumbers) {
            System.out.print("The First ");
            System.out.print(totalNumbers);
            System.out.print(" Prime Numbers --- Page ");
            System.out.println(pageNumber);
            for (int rowOffset = pageOffset; rowOffset < pageOffset + linesPerPage; rowOffset++) {
                for (int column = 0; column < columns; column++)
                    if (rowOffset + column * linesPerPage <= totalNumbers)
                        System.out.format("%10d", numbers[rowOffset + column * linesPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            pageNumber = pageNumber + 1;
            pageOffset = pageOffset + linesPerPage * columns;
        }
    }
}
