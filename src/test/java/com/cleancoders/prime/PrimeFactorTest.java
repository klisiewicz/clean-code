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
        assertThat(primesOf(1), is(emptyList()));
        assertThat(primesOf(2), is(List.of(2)));
        assertThat(primesOf(3), is(List.of(3)));
    }

    private List<Integer> primesOf(int n) {
        final ArrayList<Integer> factors = new ArrayList<>();
        if (n > 1)
            factors.add(n);
        return factors;
    }

}
