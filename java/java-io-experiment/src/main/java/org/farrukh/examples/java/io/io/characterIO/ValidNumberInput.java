package org.farrukh.examples.java.io.io.characterIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidNumberInput {

	public static void main(String[] args) {
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		String number;
		int total = 0;
		System.out.println("Input only integer numbers");
		try {
			while ((number = cin.readLine()) != null) {
				try {
					total += Integer.parseInt(number);
					System.out.println(total);
				} catch (Exception e) {
					System.out.println("Invalid number!");
					System.exit(1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
