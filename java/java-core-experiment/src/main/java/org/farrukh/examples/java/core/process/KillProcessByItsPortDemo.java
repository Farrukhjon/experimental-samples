package org.farrukh.examples.java.core.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KillProcessByItsPortDemo {

    public static void main(String[] args) {
        int port = 10007;
        killPidByItsPort(port);
    }

    private static void killPidByItsPort(final int port) {
        ProcessBuilder builder = new ProcessBuilder();
        try {
            builder.command("lsof", "-t", "-i:" + port);
            Process process = builder.start();
            try (final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line = reader.readLine();
                if (line != null) {
                    builder.command("kill", "-9", line);
                    try {
                        builder.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}