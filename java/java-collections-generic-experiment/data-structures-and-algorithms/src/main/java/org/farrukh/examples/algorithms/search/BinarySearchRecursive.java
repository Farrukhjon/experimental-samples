package search;

import java.util.Arrays;

public class BinarySearchRecursive {

	public static int searchRecursive(int[] array, int key) {
		return searchRecursive(array, key, 0, array.length - 1);
	}

	private static int searchRecursive(int[] array, int key, int left, int right) {
		if (left > right)
			return -1;
		int middle = (left + right) / 2;
		if (array[middle] == key)
			return middle;
		else if (key < array[middle])
			return searchRecursive(array, key, left, middle - 1);
		else
			return searchRecursive(array, key, middle + 1, right);
	}

	public static void show(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		int[] array = { 2, 1, 0, 3, 4, 8, 7, 5, 6 };
		show(array);
		Arrays.sort(array);
		show(array);
		int findIndex = searchRecursive(array, 5);
		System.out.println("findIndex: " + findIndex);
	}

}
