package org.farrukh.examples.java.io.io.byteIO.filterIO.bufferedIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {

	private static final String fileName = "file.dat";

	public static void main(String[] args) {
		File file = new File(fileName);
		writeToFile(file, "blah blah blah");
		readFromFile(file);
	}

	public static void writeToFile(File file, String str) {
		byte[] data = str.getBytes();
		try {
			file.createNewFile();
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(data);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFromFile(File file) {
		if (file.exists()) {
			try {
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				while (true) {
					int ch = bis.read();
					System.out.print(" " + ch);
					if (ch == -1)
						break;
				}
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			System.out.println("File not exist!");
	}
}
