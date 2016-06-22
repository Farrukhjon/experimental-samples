package org.farrukh.examples.algorithms.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenIntFile {

	public static void main(String[] args) throws IOException {

		File intFile = new File("intFile.txt");
		File doubleFile = new File("doubleFile.txt");
		intFile.createNewFile();
		doubleFile.createNewFile();
		FileWriter intout = new FileWriter(intFile);
		FileWriter doubleout = new FileWriter(doubleFile);
		BufferedWriter intWriter = new BufferedWriter(intout);
		BufferedWriter doubleWriter = new BufferedWriter(doubleout);
		Random random = new Random();
		try {
			for (int i = 0; i < 1500; i++) {
				String str1 = String.valueOf(random.nextInt());
				intWriter.write(str1 + "\n");
				String str2 = String.valueOf(random.nextDouble());
				doubleWriter.write(str2 + "\n");
			}
		} finally {
			intWriter.flush();
			doubleWriter.flush();
			intout.close();
			doubleout.close();
			intWriter.close();
			doubleWriter.close();
		}

	}
}
