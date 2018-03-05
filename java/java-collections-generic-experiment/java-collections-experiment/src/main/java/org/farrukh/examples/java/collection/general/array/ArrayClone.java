package org.farrukh.examples.java.collection.general.array;

import java.util.Arrays;

public class ArrayClone {

	public static void main(String[] args) {
		int[] original = { 0, 1, 2, 3, 4, 5, 6, 7 };
		int[] clone = original.clone();
		
		System.out.printf("%-14s %1s %n", "Original array:", Arrays.toString(original));
		System.out.printf("%-15s %1s", "Clone array:", Arrays.toString(clone));
	}

}
