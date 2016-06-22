package org.farrukh.examples.java.io.io.byteIO;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {

	public static void main(String[] args) {

		String s = "0123456789abcdefghijklmnopqrstyuvwxvz";
		byte[] buf = s.getBytes();
		try {
			InputStream bufArrayInStream = new ByteArrayInputStream(buf);
			int c;
			InputStream bis = new BufferedInputStream(bufArrayInStream);
			int i = 0;
			while ((c = bis.read()) != -1) {
				System.out.printf("%-2d %-2c", c, s.charAt(i));
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
