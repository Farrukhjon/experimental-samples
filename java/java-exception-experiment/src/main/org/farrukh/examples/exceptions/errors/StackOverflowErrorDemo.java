package org.farrukh.examples.exceptions.errors;

public class StackOverflowErrorDemo {

	private static int	count	= 0;

	public static void main(String[] args) {
		method();
	}

	private static void method() {
		count++;
		System.out.println("This is the method, count: " + count);
		try {
			method();
		} catch (StackOverflowError e) {
			return;
		}
	}

}
