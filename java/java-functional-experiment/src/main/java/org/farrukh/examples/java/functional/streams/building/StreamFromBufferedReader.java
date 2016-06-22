package org.farrukh.examples.java.functional.streams.building;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class StreamFromBufferedReader {

    public static void main(String[] args) throws FileNotFoundException {
        Stream<String> lines = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt"), UTF_8)).lines();
        lines.forEach(System.out::println);
    }

}
