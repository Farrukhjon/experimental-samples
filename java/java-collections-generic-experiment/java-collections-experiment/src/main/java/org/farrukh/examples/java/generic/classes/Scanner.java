package org.farrukh.examples.java.generic.classes;

public class Scanner<T> {
	
	private T scanner;

	public Scanner(T scanner) {
		this.setScanner(scanner);
	}

	public T getScanner() {
		return scanner;
	}

	public void setScanner(T scanner) {
		this.scanner = scanner;
	}
}
