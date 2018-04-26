package org.farrukh.examples.algorithms.sorting;


/**
 * The complexity of this algorithm, mergeSort(Object[], int lo, int hi) is
 * NlogN.
 * 
 * */
public class MergeSort extends BaseSorter {

	@Override
	public <T> void sort(Comparable<T>[] array) {
		Comparable<T>[] temp = new Comparable[array.length];
		mergeSort(array, temp, 0, array.length - 1);
	}

	private <T> void mergeSort(Comparable<T>[] array, Comparable<T>[] temp, int lo, int hi) {
		if (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			mergeSort(array, temp, lo, mid);
			mergeSort(array, temp, mid + 1, hi);
			merge(array, temp, lo, mid, hi);
		}
	}

	private <T> void merge(Comparable<T>[] array, Comparable<T>[] temp, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			temp[i] = array[i];
		}
		int i = lo;
		int j = mid + 1;
		int k = lo;
		while (i <= mid && j <= hi) {
			if (lessOrEqual(temp[i], temp[j]))
				array[k++] = temp[i++];
			else
				array[k++] = temp[j++];
		}
		while (i <= mid) {
			array[k++] = temp[i++];
		}
	}
	
	public <T> void show(Comparable<T>[] array) {
		System.out.println("Merge sorting demo result");
		super.show(array);
	};
}
