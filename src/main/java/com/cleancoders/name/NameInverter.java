package com.cleancoders.name;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class NameInverter {
    String invoke(final String name) {
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