package org.farrukh.examples.java.io.io.fileIO;

import java.io.File;
import java.io.IOException;

public class CurrentClassDir {

	public static void main(String[] args) {
		String location = CurrentClassDir.class.getResource("").getFile();
		System.out.println(location);
		File file = new File(location+"/file.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
