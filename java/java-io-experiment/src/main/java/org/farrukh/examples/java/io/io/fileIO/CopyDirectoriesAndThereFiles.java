package org.farrukh.examples.java.io.io.fileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Copy nonempty directory with files and folders demo.
 */
public class CopyDirectoriesAndThereFiles {

    public static void main(String[] args) throws IOException {
        File source = new File("src");
        File destination = new File("tmp");
        copy(source, destination);
    }

    private static void copy(final File source, final File destination) throws IOException {
        if (source.isDirectory()) {
            copyRecursively(source, destination);
        } else {
            Files.copy(source.toPath(), destination.toPath());
        }
    }

    private static void copyRecursively(final File source, final File destination) throws IOException {
        if (!destination.exists()) {
            destination.mkdir();
        }
        for (String child : source.list()) {
            copy(new File(source, child), new File(destination, child));
        }
    }

}
