package org.farrukh.examples.algorithms.math;

import java.util.Arrays;

/**
 * 
 * Z[i][j]=Sum(X[i][k]xY[j][k]); k=1,..n
 * 
 * */

public class MultiplicationTwoMatrix {

	public static void main(String[] args) {
		int[][] a = { { 4, 2, 1 }, { 1, 2, 33 }, { 1, 2, 0 } };
		int[][] b = { { 3, 1, 9 }, { 0, 3, 2 }, { 4, 7, 5 } };

		int[][] z = multi(a, b);
		print(z);
	}

	public static int[][] multi(int[][] a, int[][] b) {
		int n = a.length;
		int[][] z = new int[n][n];
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					final int x = a[k][j];
					final int y = b[j][k];
					sum += x * y;
				}
				z[k][i] = sum;
			}
		}
		return z;
	}

	public static void print(int[][] array) {
		for (int i = 0; i < array.length; i++)
			System.out.println(Arrays.toString(array[i]));
	}

}
