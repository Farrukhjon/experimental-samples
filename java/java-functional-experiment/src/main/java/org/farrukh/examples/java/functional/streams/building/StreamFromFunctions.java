package org.farrukh.examples.java.functional.streams.building;

import java.util.stream.Stream;

/**
 * Created by Farrukhjon on 12-Jan-16.
 */
public class StreamFromFunctions {

    public static void main(String[] args) {
        Stream.iterate(0, element -> element + 1)
                .limit(10000)
                .forEach(System.out::println);
        Stream.generate(Math::random)
                .limit(100)
                .forEach(System.out::println);
    }

}
