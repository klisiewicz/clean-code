package com.cleancoders.name;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NameInverterTest {
    @Test
    public void givenNullReturnsEmptyString() {
        assertInverted(null, "");
    }

    @Test
    public void givenEmptyStringReturnsEmptyString() {
        assertInverted("", "");
    }

    @Test
    public void givenSimpleNameReturnSimpleName() {
        assertInverted("Name", "Name");
    }

    private void assertInverted(String originalName, String invertedName) {
        assertThat(invertName(originalName), is(invertedName));
    }

    private String invertName(String name) {
        if (name == null) return "";
        return name;
    }
}
