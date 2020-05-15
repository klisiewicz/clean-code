package com.cleancoders.prime;

import org.junit.Test;

import java.util.ArrayList;
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
    }

    private void assertPrimerFactors(int n, List<Integer> primeFactors) {
        assertThat(primesOf(n), is(primeFactors));
    }

    private List<Integer> primesOf(int n) {
        final ArrayList<Integer> factors = new ArrayList<>();
        int divisor = 2;
        while (n > 1) {
            while (n % divisor == 0) {
                factors.add(divisor);
                n /= divisor;
            }
            divisor++;
        }
        return factors;
    }

}
