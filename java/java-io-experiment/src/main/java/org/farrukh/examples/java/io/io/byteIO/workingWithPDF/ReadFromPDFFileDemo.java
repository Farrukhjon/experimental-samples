package org.farrukh.examples.java.io.io.byteIO.workingWithPDF;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ReadFromPDFFileDemo {

	private static final String fileName = "pdfFile.pdf";

	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			String filePath = ReadFromPDFFileDemo.class.getResource(fileName).getPath();
			File pdfFile = new File(filePath);
			is = new FileInputStream(pdfFile);
			os = new PrintStream(System.out);
			byte[] buffer = new byte[8192];
			int numberOfByte = 0;
			while ((numberOfByte = is.read(buffer, 0, buffer.length)) > 0) {
				os.write(buffer, 0, numberOfByte);
				os.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
