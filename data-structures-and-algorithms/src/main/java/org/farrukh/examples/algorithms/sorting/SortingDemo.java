package org.farrukh.examples.algorithms.sorting;

import org.farrukh.examples.algorithms.util.Stopwatch;

import java.util.Arrays;

public class SortingDemo {

	public static void main(String[] args) {

		//Integer[] a = { 21, 43, 67, 7, 67, 17, 6, 88, 65, 50, 30, 42, 34 };
		Integer[] a = BaseSorter.gen();

		System.out.println("Unsorted array:\n" + Arrays.toString(a));

		BaseSorter sorter = null;
		Stopwatch stopwatch = null;


		/*		
		sorter = new BubbleSort();
		sorter.sort(a);
		sorter.show(a);
		*/
		
		/*
		sorter = new InsertionSort();
		sorter.sort(a);
		sorter.show(a);*/

		sorter = new MergeSort();
		stopwatch = new Stopwatch();
		sorter.sort(a);
		double elapsedTime = stopwatch.elapsedTime();
		System.out.println("elapsedTime: " + elapsedTime);
		sorter.show(a);

		Integer[] b = BaseSorter.gen();
		sorter = new QuickSort();
		stopwatch = new Stopwatch();
		sorter.sort(b);
		elapsedTime = stopwatch.elapsedTime();
		System.out.println("elapsedTime: " + elapsedTime);
		sorter.show(b);

		/*sorter = new SelectionSort();
		sorter.sort(a);
		sorter.show(a);

		sorter = new ShellSort();
		sorter.sort(a);
		sorter.show(a);*/
	}
}
