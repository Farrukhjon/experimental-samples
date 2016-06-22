package org.farrukh.examples.java.core.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PipeAndFilterDemo {

    public static void main(String[] args) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", "pidof chrome | wc -w");
        Process process = builder.start();
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String result;
            while ((result = reader.readLine()) != null) {
                System.out.println(result);
            }
        }
    }

}
