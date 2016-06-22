package org.farrukh.examples.java.generic.classes;

public class ScannerDemo {

	public static void main(String[] args) {
		Scanner<ScannerFast> scannerFast = new Scanner<ScannerFast>(new ScannerFast());
		Scanner<ScannerSlow> scannerSlow = new Scanner<ScannerSlow>(new ScannerSlow());
		scanOne(scannerFast);
		scanOne(scannerSlow);
	}

	private static void scanOne(Scanner<? extends IScannable> scanner) {
		scanner.getScanner().scan();
	}
}
