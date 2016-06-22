package org.farrukh.examples.java.functional.iteration;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class IterateFilterMapLimitCollect {

    public static void main(String[] args) {
        List<Double> primeNumbers = Stream.iterate(1, e -> e + 1)
                                          .filter(IterateFilterMapLimitCollect::isPrime)
                                          .map(Math::sqrt)
                                          .limit(1000)
                                          .collect(toList());
        System.out.println(primeNumbers);
    }

    private static boolean isPrime(final int number) {
        boolean divided = IntStream
                .range(2, number)
                .noneMatch(i -> number % i == 0);
        return number > 1 && divided;
    }

}
