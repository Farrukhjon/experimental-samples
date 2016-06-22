package org.farrukh.examples.java.io.io.scanner;

import org.farrukh.examples.java.io.util.ArrayGenerator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteReadIntDataToFile {

	public static void main(String[] args) {
		Integer[] a = ArrayGenerator.getInteger(10);
		write(a, new File("src/resources/intdata.txt"));
	}

	private static void write(Integer[] a, File file) {
		try (FileOutputStream fis = new FileOutputStream(file)) {
			BufferedOutputStream bus = new BufferedOutputStream(fis);
			for (Integer i : a) {
				byte b = i.byteValue();
				bus.write((char) b);
			}
			bus.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
