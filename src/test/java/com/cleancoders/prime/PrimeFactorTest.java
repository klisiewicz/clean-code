package com.cleancoders.prime;

import org.junit.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PrimeFactorTest {
    @Test
    public void shouldFactorIntoPrimes() {
        assertPrimerFactors(1, emptyList());
        assertPrimerFactors(2, List.of(2));
        assertPrimerFactors(3, List.of(3));
        assertPrimerFactors(4, List.of(2, 2));
        assertPrimerFactors(5, List.of(5));
        assertPrimerFactors(6, List.of(2, 3));
        assertPrimerFactors(7, List.of(7));
        assertPrimerFactors(8, List.of(2, 2, 2));
        assertPrimerFactors(9, List.of(3, 3));
        assertPrimerFactors(2 * 2 * 3 * 3 * 5 * 7 * 11 * 11 * 13, List.of(2, 2, 3, 3, 5, 7, 11, 11, 13));
    }

    private void assertPrimerFactors(int n, List<Integer> primeFactors) {
        assertThat(primesOf(n), is(primeFactors));
    }

    private List<Integer> primesOf(int n) {
        return new PrimeFactor().of(n);
    }
}
