package org.farrukh.examples.java.collection.general.array;

public class PrintTypeOfArray {

	public static void main(String args[]) {

		// type of one dimensional array in Java
		int[] arrayOfInts = new int[] { 101, 102, 103, 104, 105 };
		System.out.println(arrayOfInts);

		short[] arrayOfShorts = new short[] { 20, 30, 40, 50, 60 };
		System.out.println(arrayOfShorts);

		float[] arrayOfFloats = new float[] { 2.0f, 3.0f, 4.0f, 5.0f, 6.0f };
		System.out.println(arrayOfFloats);

		// type of two dimensional array in Java
		int[][] arrayOfArrayOfInts = { { 1, 2, 3 }, { 10, 20, 30 }, { 100, 200, 300 } };
		System.out.println(arrayOfArrayOfInts);

		double[][] arrayOfArrayOfDoubles = { { 2.0, 3.0 }, { 4.0, 5.0 } };
		System.out.println(arrayOfArrayOfDoubles);

	}
}
