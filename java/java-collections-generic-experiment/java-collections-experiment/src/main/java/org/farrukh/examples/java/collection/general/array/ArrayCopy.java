package org.farrukh.examples.java.collection.general.array;

public class ArrayCopy {

	public static void main(String[] args) {

		int[] sourceArray = { 1, 3, 5, 4, 6, 8, 2, 12, 45, 64, 33, 56, 76, 32 };

		int destArray1[] = new int[sourceArray.length / 2];
		int destArray2[] = new int[sourceArray.length / 2];

		System.arraycopy(sourceArray, 0, destArray1, 0, sourceArray.length / 2);
		System.arraycopy(sourceArray, 7, destArray2, 0, sourceArray.length / 2);

		printArray(sourceArray);
		printArray(destArray1);
		printArray(destArray2);
	}

	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%-3d", a[i]);
		}
		System.out.println();
	}

}
