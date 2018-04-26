package org.farrukh.examples.algorithms.sorting;

public class SelectionSort extends BaseSorter {

	@Override
	public <T> void sort(Comparable<T>[] array) {
		int size = array.length;
		for (int i = 0; i < size; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++)
				if (less(array[j], array[min]))
					min = j;
			exchange(array, i, min);
		}
	}
	
	public <T> void show(Comparable<T>[] array) {
		System.out.println("Selection sorting demo result");
		super.show(array);
	};

}
