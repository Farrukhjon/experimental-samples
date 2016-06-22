package org.farrukh.examples.java.functional.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        final List<String> stringList = Arrays.asList(null, "Hello", null, "World");
        final Optional<String> optionalValue = stringList
                .stream()
                .filter(Objects::nonNull)
                .findAny();
        System.out.println(optionalValue.isPresent());
    }

}
