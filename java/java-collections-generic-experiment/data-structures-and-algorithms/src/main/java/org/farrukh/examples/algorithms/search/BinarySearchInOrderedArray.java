package search;

public class BinarySearchInOrderedArray {

	public static void main(String[] args) {
		int[] a = { 50, 40, 10, 30, 20, 0 };
		order(a);
		show(a);
		int finedElement = find(a, 10);
		System.out.println();
		System.out.println("finedElement: " + finedElement);
	}

	private static void swap(int[] array, int l, int r) {
		int temp = array[l];
		array[l] = array[r];
		array[r] = temp;
	}

	private static void order(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++)
				if (array[j] < array[min])
					min = j;
			swap(array, i, min);
		}
	}

	private static int find(int[] array, int key) {
		int count = array.length;
		int lowerIndex = 0;
		int upperIndex = count - 1;
		int element;
		while (true) {
			element = (lowerIndex + upperIndex) / 2;
			if (array[element] == key)
				return element;
			else if (lowerIndex > upperIndex)
				return count;
			else {
				if (array[element] < key)
					lowerIndex = element + 1;
				else
					upperIndex = element - 1;
			}
		}
	}

	private static void show(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print("[" + array[i] + "]");
		}
	}
}
