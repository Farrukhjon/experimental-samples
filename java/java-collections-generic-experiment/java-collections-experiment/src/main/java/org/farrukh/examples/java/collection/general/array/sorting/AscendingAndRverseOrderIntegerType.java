package org.farrukh.examples.java.collection.general.array.sorting;

import java.util.Arrays;
import java.util.Collections;

public class AscendingAndRverseOrderIntegerType {

	public static void main(String[] args) {

		Integer[] intArray = { 0, 55, 21, 2, 5, 53, 22, 45, 67, 8, 1 };

		Arrays.sort(intArray);
		System.out.println("Increasing ordering : " + Arrays.toString(intArray));

		Arrays.sort(intArray, Collections.reverseOrder());
		System.out.println("Reverse ordering : " + Arrays.toString(intArray));

		String[] strArray = { "Ali", "Vali", "Surayo", "Muhaya", "Rano", "Sami" };

		Arrays.sort(strArray);
		System.out.println("Increasing ordering : " + Arrays.toString(strArray));

		Arrays.sort(strArray, 0, strArray.length, Collections.reverseOrder());
		System.out.println("Reverse ordering : " + Arrays.toString(strArray));

	}

}
