package org.farrukh.examples.java.collection.general.array;

public class IncrementDecrementItem {

	public static void main(String[] args) {

		int[] array = { 22, 1, 3, 4, 54, 67, 2, 13 };

		// 1)
		int i = 0;
		while (i <= 7) {
			final int value = array[i++];
			System.out.print(" " + value + " ");
		}
		
		// 2)
		i = 0;
		System.out.println();
		while (i <= 7) {
			final int value = array[i];
			System.out.print(" " + value + " ");
			i++;
		}

		//3
		i = -1;
		System.out.println();
		while (i < 7) {
			final int value = array[++i];
			System.out.print(" " + value + " ");
		}

		//4
		i = 0;
		System.out.println();
		while (i <= 7) {
			final int value = array[i];
			System.out.print(" " + value + " ");
			++i;
		}
	}
	
}
