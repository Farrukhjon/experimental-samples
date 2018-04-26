package org.farrukh.examples.algorithms.sorting;


/**
 * The complexity of this algorithm, BubleSort.sort(Comparable<T>[]) is O(n^2).
 * 
 * */

public class BubbleSort extends BaseSorter {

	@Override
	public <T> void sort(Comparable<T>[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = array.length - 1; j > i; j--) {
				if (less(array[j], array[j - 1])) {
					exchange(array, j, j - 1);
				}
			}
		}
	}
	
	public <T> void show(Comparable<T>[] array) {
		System.out.println("Bubble sorting demo result");
		super.show(array);
	};
}
