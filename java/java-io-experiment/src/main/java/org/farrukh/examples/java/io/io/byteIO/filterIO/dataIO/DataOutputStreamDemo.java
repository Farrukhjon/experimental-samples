package org.farrukh.examples.java.io.io.byteIO.filterIO.dataIO;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class DataOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		File doubleFile = new File("doubleFile.txt");
		doubleFile.createNewFile();
		FileOutputStream fileOutputStream = new FileOutputStream(doubleFile);
		DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
		Random rand = new Random();
		try {
			for (int i = 0; i < 1500; i++) {
				final double nextDouble = rand.nextDouble();
				double value = Math.round(nextDouble * 100.0) / 100.0;
				dataOutputStream.writeChars(String.valueOf(value));
				dataOutputStream.writeChars("\n");
			}
		} finally {
			dataOutputStream.close();
			fileOutputStream.close();
		}

	}
}
