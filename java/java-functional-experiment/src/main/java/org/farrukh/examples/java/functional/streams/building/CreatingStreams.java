package org.farrukh.examples.java.functional.streams.building;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CreatingStreams {

    public IntStream fromArray(int[] ints) {
        return Arrays.stream(ints);
    }

    public Stream<String> fromValues() {
        return Stream.of("Example", "of", "stream", "from", "values");
    }

    public Stream<String> fromBufferedReader() throws FileNotFoundException {
        FileInputStream in = new FileInputStream("test.txt");
        InputStreamReader streamReader = new InputStreamReader(in, UTF_8);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        return bufferedReader.lines();
    }

    public Stream<String> fromFile(String filePath) {
        try {
            return Files.lines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Stream<Integer> byIterating() {
        return Stream.iterate(0, element -> element + 1).limit(100);
    }

    public Stream<Double> byGenerating() {
        return Stream.generate(Math::random).limit(100);
    }


}
