package org.farrukh.examples.java.io.io.byteIO;

import java.io.*;
import java.util.Scanner;

public class ByteArrayIOStream {

    private static String fileName = "data.dat";

    public static void main(String[] args) {
        write();
        read();
    }

    private static void write() {
        try (Scanner scanner = new Scanner(System.in); OutputStream fos = new FileOutputStream(fileName)) {
            while (scanner.hasNext()) {
                String data = scanner.next();
                byte[] bytes = data.getBytes();
                fos.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read() {
        byte[] buf = new byte[4];
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        try {
            FileInputStream fis = new FileInputStream(fileName);
            PrintStream printStream = new PrintStream(System.out);
            while (fis.available() > 0) {
                fis.read(buf);
                printStream.write(buf);
            }
            fis.close();
            bais.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
