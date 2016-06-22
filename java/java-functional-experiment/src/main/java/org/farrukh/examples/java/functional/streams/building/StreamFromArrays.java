package org.farrukh.examples.java.functional.streams.building;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Farrukhjon on 12-Jan-16.
 */
public class StreamFromArrays {

    public static void main(String[] args) {
        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        IntStream stream = Arrays.stream(ints);
        stream.map(i -> i * 2)
                .forEach(System.out::println);
    }

}
