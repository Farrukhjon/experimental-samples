package org.farrukh.examples.java.core.process;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ShowPidOfDemo {

    public static void main(String[] args) throws InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("pidof", "chrome");
        try {
            Process process = builder.start();
            int codeError = process.waitFor();
            readMessage(process.getErrorStream());
            readMessage(process.getInputStream());
            System.out.printf("Error code: " + codeError);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readMessage(InputStream inputStream) throws IOException {
        BufferedOutputStream bus = new BufferedOutputStream(System.out);
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        int i;
        while ((i = bis.read()) > -1) {
            bus.write(i);
        }
        bus.flush();
    }

}
