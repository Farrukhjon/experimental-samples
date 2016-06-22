package math;

import java.util.Arrays;

public class MathRendomDemo {

	public static void main(String[] args) {

		double[] array = new double[10];
		for (int i = 0; i < array.length; i++) {
			double randDouble = Math.round(Math.random() * 100.0) / 100.0;
			array[i] = randDouble;
		}
		print(array, "unsorted: ");
		Arrays.sort(array);
		print(array, "sorted:   ");
	}

	private static void print(double[] array, String str) {
		System.out.print(str + "[");
		for (double value : array)
			System.out.print(value + ",");
		System.out.print("]\n");
	}

}
