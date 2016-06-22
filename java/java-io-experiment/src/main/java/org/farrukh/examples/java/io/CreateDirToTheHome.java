package org.farrukh.examples.java.io;

import java.io.File;
import java.io.IOException;

public class CreateDirToTheHome {

    public static void main(String[] args) {
        String userHome = System.getProperty("user.home");
        String separator = System.getProperty("file.separator");
        String dir = userHome + separator + "mydir" + separator + "my_subdir";
        File file = new File(dir);
        if (!file.exists()) {
            boolean result = file.mkdirs();
            System.out.println(dir);
            System.out.println(result);
        }
        File someFile = new File(dir + separator + "somefile.txt");
        try {
            someFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
