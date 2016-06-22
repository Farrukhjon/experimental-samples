package org.farrukh.examples.algorithms.recursion;

import org.farrukh.examples.algorithms.util.Stopwatch;

public class IterativeAndRecursiveFactorial {

	public static void main(String[] args) {
		Stopwatch stopwatch1 = new Stopwatch();
		long result = recursiveFac(25);
		System.out.println("elapsed time for recursive:" + stopwatch1.elapsedTime());
		
		System.out.println(result);

		result = 0;
		Stopwatch stopwatch2 = new Stopwatch();
		result = iterativeFac(25);
		System.out.println("elapsed time for iterative:" + stopwatch2.elapsedTime());
		System.out.println(result);
	}

	private static long recursiveFac(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * recursiveFac(n - 1);
	}

	private static long iterativeFac(int n) {
		if (n == 0 || n == 1)
			return 1;
		long result = 1;
		for (int i = 2; i <= n; i++)
			result = result * i;
		return result;
	}
}
