package org.farrukh.examples.java.collection.general.array;

import java.util.Arrays;

public class MultiplicationVectorToMatrix {

	public static void main(String[] args) {

		double[][] matrix = { { .3, .5, .9 }, { .1, .11, 4.4 }, { .1, 1.1, 5.2 } };
		double[] vector = { 2.1, .4, .3 };

		System.out.println(Arrays.toString(multiplieDouble(matrix, vector)));

		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] d = { 1, 2, 3 };

		System.out.println(Arrays.toString(multiplieInt(a, d)));
	}

	private static int[] multiplieInt(int[][] a, int[] b) {
		int[] temp = new int[b.length];
		for (int i = 0; i < b.length; i++) {
			int sum = 0;
			for (int j = 0; j < b.length; j++) {
				sum += a[i][j] * b[j];
			}
			temp[i] = sum;
		}
		return temp;
	}

	private static double[] multiplieDouble(double[][] a, double[] b) {
		double[] temp = new double[b.length];
		for (int i = 0; i < b.length; i++) {
			double sum = 0.0;
			for (int j = 0; j < b.length; j++) {
				final double d = a[i][j];
				final double e = b[j];
				sum += d * e;
			}
			temp[i] = sum;
		}
		return temp;
	}

}
