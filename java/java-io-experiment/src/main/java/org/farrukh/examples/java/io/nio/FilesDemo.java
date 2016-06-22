package org.farrukh.examples.java.io.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FilesDemo {

    public static void main(String[] args) {
        final File file = new File("MyFile.txt");
        final Path path = file.toPath();
        try (final Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
