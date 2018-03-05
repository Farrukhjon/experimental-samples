package org.farrukh.examples.java.collection.general.array;

import java.util.Arrays;

public class DeepEqualsMultiDimensionalArray {

	public static void main(String args[]) {

		int[][] a1 = { { 2, 4 }, { 4, 6 }, { 8, 10 } };
		int[][] a2 = { { 12, 14 }, { 14, 16 }, { 18, 20 } };
		int[][] a3 = { { 2, 4 }, { 4, 6 }, { 8, 10 } };

		// checking if two multi-dimensional array of same length but different
		// element equal or not
		boolean result = Arrays.deepEquals(a1, a2);
		System.out.println("Does two dimensional array a1 and a2 are equal : " + result);

		// checking if two multi-dimensional array of same length, elements
		// equal or not
		result = Arrays.deepEquals(a1, a3);
		System.out.println("Does two dimensional array a1 and a3 are equal : " + result);

	}

}
