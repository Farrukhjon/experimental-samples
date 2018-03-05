package org.farrukh.examples.java.collection.general.array;

import java.util.Arrays;

public class ArrayComparisionDemo {

	public static void main(String args[]) {

		// Example 1 : Comparing two int arrays in Java
		int[] even = { 2, 4, 6 };
		int[] meEvenToo = { 2, 4, 6 };
		int[] odd = { 3, 5, 7 };

		boolean result = Arrays.equals(even, meEvenToo);
		System.out.printf("Comparing two int arrays %s and %s, are they Equal? %s %n ", Arrays.toString(even), Arrays.toString(meEvenToo), result);

		result = Arrays.equals(even, odd);
		System.out.printf("Comparing even and odd int arrays %s and %s, are they Equal? %s %n", Arrays.toString(even), Arrays.toString(odd), result);

		// Example 2 : Comparing two String array in Java
		String[] numbers = { "one", "two" };
		String[] numeric = { "three", "two" };
		String[] digits = { "one", "two" };

		result = Arrays.equals(numbers, numeric);
		System.out.printf("Comparing two String arrays %s and %s, are they Equal? %s %n ", Arrays.toString(numbers), Arrays.toString(numeric), result);

		result = Arrays.equals(numbers, digits);
		System.out.printf("Comparing two unequal String arrays %s and %s, are they same? %s %n", Arrays.toString(numbers), Arrays.toString(digits), result);

		// Example 3 : Comparing two multi-dimensional array in Java
		char[][] abcd = { { 'A', 'B' }, { 'C', 'D' } };
		char[][] efgh = { { 'E', 'F' }, { 'G', 'H' } };
		char[][] ABCD = { { 'A', 'B' }, { 'C', 'D' } };

		result = Arrays.equals(abcd, efgh);
		System.out.printf("Comparing two dimensional arrays %s and %s in Java, Equal? %s %n", Arrays.deepToString(abcd), Arrays.deepToString(efgh), result);

		result = Arrays.deepEquals(abcd, ABCD); // using equals() will return
												// false
		System.out.printf("Comparing unequal two dimensional char arrays %s and %s in Java, are they same? %s %n", Arrays.deepToString(abcd), Arrays.deepToString(ABCD), result);
	}
}
