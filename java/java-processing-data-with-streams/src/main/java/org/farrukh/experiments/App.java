package org.farrukh.experiments;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];

        List<String> lines = readLinesAsStreamFromFileName(fileName).collect(Collectors.toList());

        for (int i = 1; i < args.length; i++) {
            String regex = args[i];
            Objects.requireNonNull(regex);
            Predicate<String> predicate = Pattern.compile(regex).asPredicate();

            long count = countByPredicate(lines, predicate);

            System.out.printf("\nClass or Interface category: %s, count: %s", regex, count);
        }

    }

    private static long countByPredicate(List<String> lines, Predicate<String> predicate) {
        return lines
                .stream()
                .filter(predicate)
                .count();
    }

    private static Stream<String> readLinesAsStreamFromFileName(String fileName) throws FileNotFoundException {
        Objects.requireNonNull(fileName);
        return new BufferedReader(new FileReader(fileName)).lines();
    }
}
