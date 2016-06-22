package org.farrukh.examples.java.functional.streams.building;

import java.util.stream.Stream;

/**
 * Created by Farrukhjon on 12-Jan-16.
 */
public class StreamFromValues {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Example", "of", "stream", "from", "values");
        stream
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

}
