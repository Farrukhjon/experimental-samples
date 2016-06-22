package org.farrukh.examples.java.io.io.byteIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class SequenceInputStreamDemo {

	public static void main(String[] args) throws IOException {
		demo1();
		demo2();
	}

	private static void demo1() throws IOException {
		InputStream is1 = null;
		InputStream is2 = null;
		SequenceInputStream sis = null;
		try {
			is1 = new FileInputStream("src/resources/file1.txt");
			is2 = new FileInputStream("src/resources/file2.txt");
			sis = new SequenceInputStream(is1, is2);
			int value;
			while ((value = sis.read()) != -1) {
				System.out.printf("%-1s", (char) value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			is1.close();
			is2.close();
			sis.close();
		}

	}

	private static void demo2() throws IOException {
		InputStream is1 = null;
		InputStream is2 = null;
		SequenceInputStream sis = null;
		try {
			is1 = new FileInputStream("src/resources/file1.txt");
			is2 = new FileInputStream("src/resources/file2.txt");
			List<InputStream> list = Arrays.asList(is1, is2);
			Enumeration<InputStream> elements = Collections.enumeration(list);
			sis = new SequenceInputStream(elements);
			int value;
			while ((value = sis.read()) != -1) {
				System.out.printf("%-1s", (char) value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			is1.close();
			is2.close();
			sis.close();
		}
	}
}
