package org.farrukh.examples.java.generic.methods;

public class GenMethodIsInArray {

	public static void main(String[] args) {
		Integer[] numbers = { 1, 2, 3, 4, 5, 6 };
		isIn(1, numbers);
		isIn(34, numbers);

		String[] strs = { "Hello", "My", "Best", "Friend" };
		isIn("My", strs);
		isIn("HelloMy", strs);
	}

	private static <T, V extends T> boolean isIn(T x, V[] y) {
		for (int i = 0; i < y.length; i++) {
			if (x.equals(y[i])) {
				System.out.println(x + " in " + y.toString() + " true");
				return true;
			}
		}
		System.out.println(x + " in " + y.toString() + " false");
		return false;
	}
}
