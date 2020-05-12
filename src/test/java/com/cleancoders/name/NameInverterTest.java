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

    @Test
    public void givenFirstLastReturnsLastFirst() {
        assertInverted("First Last", "Last, First");
    }

    @Test
    public void givenSimpleNameWithSpacesReturnsSimpleNameWithoutSpaces() {
        assertInverted(" Name ", "Name");
    }

    @Test
    public void givenFirstLastWithExtraSpacesReturnsLastFirst() {
        assertInverted(" First  Last ", "Last, First");
    }

    private void assertInverted(String originalName, String invertedName) {
        assertThat(invertName(originalName), is(invertedName));
    }

    private String invertName(final String name) {
        if (name == null) {
            return "";
        } else {
            final String[] names = name.trim().split("\\s+");
            if (names.length == 1) {
                return names[0];
            } else {
                return String.format("%s, %s", names[1], names[0]);
            }
        }
    }
}
