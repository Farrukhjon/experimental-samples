package org.farrukh.examples.java.io.io.scanner;

import java.util.Scanner;

public class ReadFromConsoleByScanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int value = scanner.nextInt();
			System.out.println(Math.pow(value, 2));
		}
	}
}