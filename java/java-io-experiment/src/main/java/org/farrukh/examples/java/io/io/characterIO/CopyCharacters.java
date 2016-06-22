package org.farrukh.examples.java.io.io.characterIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyCharacters {

	public static void main(String[] args) throws IOException {
		FileReader in = null;
		FileWriter out = null;
		try {
			in = new FileReader(createInFile("resources/input.txt"));
			out = new FileWriter("resources/output.txt");
			int i;
			while ((i = in.read()) != -1) {
				out.write(i);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	protected static void readFromFile(File file) throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String l;
		while ((l = reader.readLine()) != null) {
			new PrintWriter(file).println(l);
		}
		reader.close();
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
