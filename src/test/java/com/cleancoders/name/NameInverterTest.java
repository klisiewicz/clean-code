package com.cleancoders.name;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NameInverterTest {
    private NameInverter nameInverter;

    @Before
    public void setUp() {
        nameInverter = new NameInverter();
    }

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

    @Test
    public void givenHonorificFirstLastReturnsLastFirs() {
        assertInverted("Mr. First Last", "Last, First");
        assertInverted("Mrs. First Last", "Last, First");
    }

    @Test
    public void givenFirstLastPostNominalReturnsLastFirsPostNominal() {
        assertInverted("First Last Sr.", "Last, First Sr.");
        assertInverted("First Last BS. Phd.", "Last, First BS. Phd.");
    }

    @Test
    public void givenFirstLastSpacesPostNominalReturnsLastFirsPostNominal() {
        assertInverted("    Robert   Martin   III esq.   ", "Martin, Robert III esq.");
    }

    private void assertInverted(String originalName, String invertedName) {
        assertThat(nameInverter.invoke(originalName), is(invertedName));
    }
}
