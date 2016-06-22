package org.farrukh.examples.algorithms.sorting;

public class QuickSort extends BaseSorter {

	private <T> void sort(Comparable<T>[] array, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(array, lo, hi);
		sort(array, lo, j - 1);
		sort(array, j + 1, hi);
	}

	private <T> int partition(Comparable<T>[] array, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable<T> pivot = array[lo];
		while (true) {
			while (less(array[++i], pivot))
				if (i == hi)
					break;
			while (less(pivot, array[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exchange(array, i, j);
		}
		exchange(array, lo, j);
		return j;
	}

	@Override
	public <T> void sort(Comparable<T>[] array) {
		sort(array, 0, array.length - 1);
	}
	
	public <T> void show(Comparable<T>[] array) {
		System.out.println("Quick sorting demo");
		super.show(array);
	};

}
