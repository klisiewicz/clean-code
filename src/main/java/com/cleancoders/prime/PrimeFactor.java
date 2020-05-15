package com.cleancoders.prime;

import java.util.ArrayList;
import java.util.List;

public final class PrimeFactor {
    public List<Integer> of(int n) {
        final ArrayList<Integer> factors = new ArrayList<>();
        for (int divisor = 2; n > 1; divisor++)
            for (; n % divisor == 0; n /= divisor)
                factors.add(divisor);
        return factors;
    }
}
