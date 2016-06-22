package org.farrukh.examples.java.io.io.characterIO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class LineNumberReaderDemo {

	private static final String fileName = "MyFile.txt";

	public static void main(String[] args) {
		try {
			Reader readerIn = new FileReader(new File(fileName));
			LineNumberReader lineReader = new LineNumberReader(readerIn);
			Writer writer = new PrintWriter(System.out);
			String line;
			while ((line = lineReader.readLine()) != null) {
				writer.write(line);
				writer.write("\n");
			}
			lineReader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
