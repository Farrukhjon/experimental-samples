package org.farrukh.examples.java.io.io.fileIO;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenFileDemo {

	public static void main(String[] args) {
		File  openingFile = new File("file.txt");
		try {
			openingFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try{
			Desktop.getDesktop().open(openingFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
