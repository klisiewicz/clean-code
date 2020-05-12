package com.cleancoders.name;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        assertThat(invertName(originalName), is(invertedName));
    }

    private String invertName(final String name) {
        if (name == null) {
            return "";
        } else {
            final List<String> names = splitNames(name);
            if (names.size() > 1 && isHonorific(names.get(0))) {
                names.remove(0);
            }
            if (names.size() == 1) {
                return names.get(0);
            } else {
                final String postNominal = names.size() > 2 ? getPostNominals(names) : "";
                return String.format("%s, %s %s", names.get(1), names.get(0), postNominal).trim();
            }
        }
    }

    private ArrayList<String> splitNames(String name) {
        return new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
    }

    private boolean isHonorific(String word) {
        return word.matches("Mr\\.|Mrs\\.");
    }

    private String getPostNominals(List<String> names) {
        final List<String> postNominals = names.subList(2, names.size());
        return String.join(" ", postNominals);
    }
}
