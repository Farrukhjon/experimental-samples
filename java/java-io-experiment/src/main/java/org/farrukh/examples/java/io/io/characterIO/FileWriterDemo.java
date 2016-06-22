package org.farrukh.examples.java.io.io.characterIO;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String[] args) {
		String fileName = args[0];
		String data = "This is message";
		write(fileName, data);
	}

	private static void write(String fileName, String data) {
		try (FileWriter fw = new FileWriter(fileName)) {
			byte[] bayts = data.getBytes();
			for (byte b : bayts) {
				fw.write(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
