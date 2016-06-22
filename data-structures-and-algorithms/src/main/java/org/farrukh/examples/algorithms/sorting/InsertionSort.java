package org.farrukh.examples.algorithms.sorting;

public class InsertionSort extends BaseSorter {

	@Override
	public <T> void sort(Comparable<T>[] array) {
		int N = array.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(array[j], array[j - 1]); j--)
				exchange(array, j, j - 1);
		}
	}
	
	public <T> void show(Comparable<T>[] array) {
		System.out.println("Insertion sorting demo result");
		super.show(array);
	};

}
