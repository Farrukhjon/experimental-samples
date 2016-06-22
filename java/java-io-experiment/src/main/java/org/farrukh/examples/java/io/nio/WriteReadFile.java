package org.farrukh.examples.java.io.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;

public class WriteReadFile {

	public static void main(String[] args) throws IOException {
		File file = new File("src/resources/myfile.txt");
		file.createNewFile();
		String strData = "dsjfkjdsfjdskfjdskfjdskfjdkfvncfewifjncmvjdherivndmcvcsmwe32132rdsm,vnv58ghvdm,23r932";
		writeToFile(file, strData);
		String newStrData = readFromFile(file);
		System.out.println(newStrData);
	}

	private static void writeToFile(File file, String data) throws IOException {
		try (final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
			ByteBuffer byteBuffer = ByteBuffer.allocate(128);
			final byte[] bytesFromData = data.getBytes();
			for (int i = 0; i < bytesFromData.length; i++) {
				bw.write(bytesFromData[i]);
			}
		}
	}

	private static String readFromFile(File file) throws FileNotFoundException, IOException {
		StringBuilder data = new StringBuilder();
		try (final BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			int i;
			while ((i = br.read()) != -1) {
				data.append((char) i);
			}
		}
		return data.toString();
	}
}
