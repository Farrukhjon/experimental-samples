package org.farrukh.examples.java.collection.general.array.sorting;

import java.util.Arrays;

public class AscendingOrderPrimitiveType {

	public static void main(String[] args) {

		int[] random = { 12, 45, 3, 21, 4, 42, 13, 78, 2, 1 };
		System.out.println("array before ascending sort: " + Arrays.toString(random));
		Arrays.sort(random);
		System.out.println("array after ascending sort: " + Arrays.toString(random));
	}

}
