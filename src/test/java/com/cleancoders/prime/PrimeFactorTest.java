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
    }

    private void assertPrimerFactors(int n, List<Integer> primeFactors) {
        assertThat(primesOf(n), is(primeFactors));
    }

    private List<Integer> primesOf(int n) {
        final ArrayList<Integer> factors = new ArrayList<>();
        if (n > 1) {
            if (n % 2 == 0) {
                factors.add(2);
                n /= 2;
            }
            if (n > 1) {
                factors.add(n);
            }
        }
        return factors;
    }

}
