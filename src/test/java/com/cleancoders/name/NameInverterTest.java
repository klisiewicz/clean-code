package com.cleancoders.name;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NameInverterTest {
    @Test
    public void givenNullReturnsEmptyString() {
        assertThat(invertName(null), is(""));
    }

    @Test
    public void givenEmptyStringReturnsEmptyString() {
        assertThat(invertName(""), is(""));
    }

    private String invertName(String name) {
        return "";
    }
}
