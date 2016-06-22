package org.farrukh.examples.java.io.io.byteIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class CopyBytesFromFileToFile {

	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(createInFile("resources/input.txt"));
			out = new FileOutputStream("resources/output.txt");
			int i;
			while ((i = in.read()) != -1) {
				out.write(i);
			}
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

	private static File createInFile(String fileName) throws IOException {
		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		writeToFile(file);
		return file;
	}

	private static void writeToFile(File file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (int i = 0; i < 10; i++) {
			writer.write(String.valueOf(i) + "\n");
		}
		writer.close();
	}
}
