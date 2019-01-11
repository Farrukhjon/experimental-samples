package org.farrukh.examples.exceptions.runtimeException;

public class StringIndexOutOfBoundsExceptionDemo {

	public static void main(String[] args) {
		String str = "abc";
		getLastChar(str);
	}
	
	private static char getLastChar(String str) {
		int lenght = str.length(); // must be str.length() - 1;
		return str.charAt(lenght);
	}

}
