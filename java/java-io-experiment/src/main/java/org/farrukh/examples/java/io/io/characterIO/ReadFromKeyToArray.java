package org.farrukh.examples.java.io.io.characterIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromKeyToArray {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int size = 0;
		System.out.println("Enter number for setting zise of arrays");
		System.out.println();
		try {
			size = Integer.parseInt(in.readLine());
		} catch (NumberFormatException nEx) {
			nEx.printStackTrace();
		}
		String[] array = new String[size];
		for (int i = 0; i < size; i++) {
			array[i] = in.readLine();
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}

}
