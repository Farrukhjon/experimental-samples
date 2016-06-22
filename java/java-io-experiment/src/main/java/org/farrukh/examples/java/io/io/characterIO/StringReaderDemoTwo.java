package org.farrukh.examples.java.io.io.characterIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

public class StringReaderDemoTwo {

	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedReader br = null;
		StringReader sr = null;
		try {
			fis = new FileInputStream("src/io/info.txt");
			br = new BufferedReader(new InputStreamReader(fis));
			final StringWriter out = new StringWriter();
			BufferedWriter writer = new BufferedWriter(out);
			int i;
			char[] buff = new char[1024];
			while ((i = br.read()) != -1) {
				writer.write(i);
			}
			sr = new StringReader(out.toString());
			sr.read(buff);
			System.out.println(Arrays.toString(buff));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
