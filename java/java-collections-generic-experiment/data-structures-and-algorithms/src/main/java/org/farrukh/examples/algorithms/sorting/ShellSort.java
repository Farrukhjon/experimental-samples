package org.farrukh.examples.algorithms.sorting;

public class ShellSort extends BaseSorter {

	@Override
	public <T> void sort(Comparable<T>[] array) {
		int N = array.length;
		int d = N / 3;
		while (d >= 1) {
			for (int i = d; i < N; i++) {
				for (int j = i; j >= d; j -= d)
					if (less(array[j], array[j - d]))
						exchange(array, j, j - d);
			}
			d /= 3;
		}
	}

	public <T> void show(Comparable<T>[] array) {
		System.out.println("Shell sorting demo result");
		super.show(array);
	}

	public static void main(String[] args) {
		BaseSorter sorter = new ShellSort();
		Integer[] a = { 40, 11, 83, 57, 32, 21, 75, 64 };
		sorter.sort(a);
		sorter.show(a);
	}

}
