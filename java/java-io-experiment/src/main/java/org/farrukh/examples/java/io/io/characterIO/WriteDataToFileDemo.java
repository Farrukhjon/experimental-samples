package org.farrukh.examples.java.io.io.characterIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteDataToFileDemo {

	public static void main(String[] args) throws IOException {
		String path = WriteDataToFileDemo.class.getResource("").getFile();
		String data = "Hello i'm a data";
		File file = new File(path + "/file.txt");
		file.createNewFile();
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(data);
		bufferedWriter.flush();

		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		int chr;
		while ((chr = bufferedReader.read()) != -1) {
			outputStreamWriter.write(chr);
			outputStreamWriter.flush();
		}
	}

}
