package org.farrukh.examples.java.io.io.fileIO;

import java.io.File;

public class FileObjects {

	public static void main(String[] args) {
		File myFile = new File("/tmp");
		String fileName = myFile.getName();
		String filePath = myFile.getPath();
		System.out.println("Name of file = " + fileName);
		System.out.println("Path of file = " + filePath);
	}
}
