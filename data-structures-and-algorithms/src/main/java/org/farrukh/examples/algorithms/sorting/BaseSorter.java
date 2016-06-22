package org.farrukh.examples.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public abstract class BaseSorter {

	public abstract <T> void sort(Comparable<T>[] array);

	public boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public boolean great(Comparable v, Comparable w) {
		return v.compareTo(w) > 0;
	}

	public boolean lessOrEqual(Comparable v, Comparable w) {
		return v.compareTo(w) <= 0;
	}

	public void exchange(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public final <T> void exchange(Comparable<T>[] array, int i, int j) {
		Comparable<T> temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public final <T> boolean isSorted(Comparable<T>[] array) {
		return isSorted(array, 0, array.length - 1);
	}

	private <T> boolean isSorted(Comparable<T>[] array, int lo, int hi) {
		for (int i = lo + 1; i < hi; i++)
			if (less(array[i], array[i - 1]))
				return false;
		return true;
	}

	public <T> void show(Comparable<T>[] array) {
		System.out.println(Arrays.toString(array));
	}

	public final void show(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	public <T> void show(char[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static Integer[] gen() {
		int size = 10;
		Random r = new Random();
		Integer[] a = new Integer[size];
		for (int i = 0; i < size; i++) {
			a[i] = r.nextInt(size);
		}
		return a;
	}

}
