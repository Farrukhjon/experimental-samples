package org.farrukh.examples.java.functional.streams.building;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Farrukhjon on 12-Jan-16.
 */
public class StreamFromFiles {

    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("test.txt"), Charset.defaultCharset())) {
            long countOfUniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println(countOfUniqueWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
