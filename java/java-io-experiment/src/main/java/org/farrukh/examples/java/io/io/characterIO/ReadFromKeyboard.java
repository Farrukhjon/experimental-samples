package org.farrukh.examples.java.io.io.characterIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromKeyboard {

	public static void main(String[] args) {
		InputStreamReader istream = new InputStreamReader(System.in);
		BufferedReader bufReader = new BufferedReader(istream);
		System.out.println("Welcome To The I/O Java Program");
		while (true)
			try {
				final String readedValue = bufReader.readLine();
				if (readedValue.equalsIgnoreCase("exit"))
					System.exit(0);
				System.out.println(readedValue);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
