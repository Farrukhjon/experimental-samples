package org.farrukh.examples.exceptions.runtimeException;

public class NullPoinerExceptionInArray {

	private static String[] strs;
	
	public static void main(String[] args) {
		
		String element = strs[0]; // java.lang.NullPointerException
		System.out.println(element);
		
	}

}
