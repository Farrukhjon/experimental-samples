package org.farrukh.examples.java.core.process;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessBuilderDemo {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("pidof", "ssh");
        try {
            Process lsProcess = pb.start();
            readInput(lsProcess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readInput(final Process lsProcess) throws IOException {
        List<String> pids = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(lsProcess.getInputStream())))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                pids.add(line);
            }
        }
    }

}
