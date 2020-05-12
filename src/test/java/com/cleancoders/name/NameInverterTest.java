package com.cleancoders.name;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        return name == null ? "" : formatName(removeHonorifics(splitNames(name)));
    }

    private List<String> splitNames(final String name) {
        return Arrays.asList(name.trim().split("\\s+"));
    }

    private List<String> removeHonorifics(final List<String> names) {
        return names.stream().filter(this::isNotHonorific).collect(Collectors.toList());
    }

    private boolean isNotHonorific(final String word) {
        return !word.matches("Mr\\.|Mrs\\.");
    }

    private String formatName(final List<String> names) {
        return names.size() == 1 ? names.get(0) : formatMultiElementName(names);
    }

    private String formatMultiElementName(final List<String> names) {
        final String postNominals = getPostNominals(names);
        final String firstName = names.get(0);
        final String lastName = names.get(1);
        return String.format("%s, %s %s", lastName, firstName, postNominals).trim();
    }

    private String getPostNominals(final List<String> names) {
        if (names.size() <= 2) return "";
        final List<String> postNominals = names.subList(2, names.size());
        return String.join(" ", postNominals);
    }
}
