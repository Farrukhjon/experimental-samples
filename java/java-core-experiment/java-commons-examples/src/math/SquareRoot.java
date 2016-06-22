package math;

import java.util.Arrays;

public class SquareRoot {

	public static void main(String[] args) {
		double[] a = new double[100];
		for (int i = 0; i < 100; i++) {
			double result = Math.sqrt(i);
			a[i] = Math.round(result * 100.0) / 100.0;
		}
		System.out.println(Arrays.toString(a));
	}

}
