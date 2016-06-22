package org.farrukh.examples.java.io.io.characterIO;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) {
		final String fileName = args[0];
		try (FileReader fr = new FileReader(fileName)) {
			int read;
			while ((read = fr.read()) != -1) {
				System.out.printf("%-1s", (char) read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
