package org.farrukh.examples.java.core.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PidsToList {

    public static void main(String[] args) {
        try {
            List<String> pids = readPIDsToList("chrome");
            pids.forEach(System.out::println);
            System.out.println(pids.stream().count());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readPIDsToList(final String arg) throws IOException, InterruptedException {
        Process pidProcess = new ProcessBuilder("pidof", arg).start();
        List<String> pids = new ArrayList<>();
        if (pidProcess.waitFor() == 0) {
            try (final BufferedReader reader = new BufferedReader(new InputStreamReader(pidProcess.getInputStream()))) {
                String line = reader.readLine();
                pids = Arrays.stream(line.split(" ")).collect(Collectors.toList());
            }
        }
        return pids;
    }

}
