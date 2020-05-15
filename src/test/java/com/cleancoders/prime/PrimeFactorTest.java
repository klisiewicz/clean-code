package com.cleancoders.prime;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PrimeFactorTest {
    @Test
    public void shouldFactorIntoPrimes() {
        assertThat(list(), is(of(1)));
    }

    private List<Integer> of(int n) {
        return new ArrayList<>();
    }

    private List<Integer> list() {
        return List.of();
    }
}
