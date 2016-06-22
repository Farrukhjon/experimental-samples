package org.farrukh.examples.java.collection.general.array;

import java.util.Arrays;

public class ReverseElements {

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println("Original array: " + Arrays.toString(a));
		reverse(a);
		System.out.println("Reversed array: " + Arrays.toString(a));
	}

	private static void reverse(int[] a) {
		if (a == null)
			return;
		int j = a.length - 1;
		int i = 0;
		while (j > i) {
			int tem = a[j];
			a[j] = a[i];
			a[i] = tem;
			j--;
			i++;
		}
	}

}
