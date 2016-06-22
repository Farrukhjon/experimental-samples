package org.farrukh.examples.java.collection.general.array;

import java.util.Arrays;

public class EqualtyTwoIntArray {

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3 };
		int[] b = { 0, 1, 2, 3 };

		System.out.println("Array a: " + Arrays.toString(a));
		System.out.println("Array b: " + Arrays.toString(b));

		System.out.printf("%-54s %1s %n", "Is array a equals to array b?, by a.equals(b):", a.equals(b));
		System.out.printf("%-54s %1s %n", "Is array a equals to array b?, by a == b:", a == b);
		System.out.printf("%-50s %1s %n", "Is array a equals to array b?, by Arrays.equals(a, b):", Arrays.equals(a, b));
	}
}
