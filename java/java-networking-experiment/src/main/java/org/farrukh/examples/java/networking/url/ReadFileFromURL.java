package org.farrukh.examples.java.networking.url;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ReadFileFromURL {

    public static void main(String[] args) {
        try {
            String urlPath = "http://www.w3schools.com/sql/default.asp";
            URLConnection urlConnection = new URL(urlPath).openConnection();
            try (final BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
                 final BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File("test.html")))) {
                byte[] buff = new byte[8192];
                while (bufferedInputStream.read(buff) > 0) {
                    outputStream.write(buff);
                }
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
