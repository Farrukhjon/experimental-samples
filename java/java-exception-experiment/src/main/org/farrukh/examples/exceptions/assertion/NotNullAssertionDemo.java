package org.farrukh.examples.exceptions.assertion;

public class NotNullAssertionDemo {

	public static void main(String[] args) {
		int result = div(1, 0);
		System.out.println(result);
	}

	private static int div(int a, int b) {
		assert (b > 0);
		return a / b;
	}

}
