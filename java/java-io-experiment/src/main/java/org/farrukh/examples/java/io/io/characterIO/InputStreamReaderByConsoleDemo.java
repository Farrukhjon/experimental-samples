package org.farrukh.examples.java.io.io.characterIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderByConsoleDemo {

	public static void main(String[] args) throws IOException {

		Reader is = new BufferedReader(new InputStreamReader(System.in));
		int a;
		while ((a = is.read()) != -1) {
			System.out.print((char)a);
		}
	}

}
