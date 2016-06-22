package org.farrukh.examples.exceptions.runtimeException;

public class DivideByZero {

	public static void main(String[] args) {
		int value = divide1(1, 2);
		System.out.println(value);
		// value = divide1(2, 0);
		value = divide2(2, 0);
		System.out.println(value);
	}

	private static int divide1(int a, int b) {
		int result = 0;
		try {
			result = a / b;
		} catch (ArithmeticException exception) {
			final String message = exception.getMessage();
			System.err.println(message);
		}
		return result;
	}

	private static int divide2(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("You can\'t divide by zero!");
		} else {
			return a / b;
		}
	}

}
