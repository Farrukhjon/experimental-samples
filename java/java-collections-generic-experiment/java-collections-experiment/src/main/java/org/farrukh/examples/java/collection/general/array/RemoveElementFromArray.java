package org.farrukh.examples.java.collection.general.array;

import java.util.Arrays;

public class RemoveElementFromArray {

	public static void main(String[] args) {

		int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.printf("%-45s %1s %n", "Array before removing first element at index 0:", Arrays.toString(intArray));
		System.out.printf("%-50s %1s %n", "Array after removing first element at index 0:", Arrays.toString(removeFirstElement(intArray)));
	}

	private static int[] removeFirstElement(int[] array) {
		int size = array.length;
		int[] temp = new int[--size];
		int numMoved = temp.length - 1;
		if (numMoved > 0) {
			System.arraycopy(array, 1, temp, 0, numMoved + 1);
		}
		array = null; //gc 
		return temp;
	}
}
