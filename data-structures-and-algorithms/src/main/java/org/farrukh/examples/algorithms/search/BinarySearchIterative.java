package search;

import java.util.Arrays;

public class BinarySearchIterative {

	public static int searchIterative(int[] array, int key) {
		int lo = 0;
		int hi = array.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key == array[mid])
				return mid;
			else if (key < array[mid])
				hi = mid - 1;
			else if (key > array[mid])
				lo = mid + 1;
		}
		return -1;
	}


	public static void show(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		int[] array = { 10, 11, 12, 13, 14, 15, 16, 17, 18 };
		show(array);
		Arrays.sort(array);
		show(array);
		int findIndex = searchIterative(array, 10);
		System.out.println("findIndex: " + findIndex);
	}

}
