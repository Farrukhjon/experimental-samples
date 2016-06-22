package org.farrukh.examples.java.io.io.scanner;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.next();
			double doubleValue = scanner.nextDouble();
			int intValue = scanner.nextInt();
			System.out.println(str);
			System.out.println(doubleValue);
			System.out.println(intValue);
		}
	}

}
