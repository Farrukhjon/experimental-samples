package org.farrukh.examples.algorithms.recursion.binaryRecursion;

public class Fibonacci {

	public static long fiboRec(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		return fiboRec(n - 1) + fiboRec(n - 2);
	}

	public static long fiboIter(int n) {
		if (n == 0)
			return 0;
		long[] temp = new long[n + 1];
		temp[0] = 0;
		temp[1] = 1;
		for (int i = 2; i <= n; i++) {
			temp[i] = temp[i - 1] + temp[i - 2];
		}
		return temp[n];
	}

	public static void main(String[] args) {
		System.out.println(fiboRec(7));
		System.out.println(fiboIter(7));
	}
}
