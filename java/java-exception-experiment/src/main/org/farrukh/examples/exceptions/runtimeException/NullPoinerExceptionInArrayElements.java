package org.farrukh.examples.exceptions.runtimeException;

public class NullPoinerExceptionInArrayElements {

	public static void main(String[] args) {

		String[] strs = new String[3];
		
		int lenght = strs[1].length(); // java.lang.NullPointerException
		
		System.out.println(lenght);
	}

}
