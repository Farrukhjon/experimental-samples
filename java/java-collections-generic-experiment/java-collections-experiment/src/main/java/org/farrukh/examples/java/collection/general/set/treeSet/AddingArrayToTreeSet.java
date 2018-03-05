package org.farrukh.examples.java.collection.general.set.treeSet;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AddingArrayToTreeSet {

	public static void main(String[] args) {

		Integer[] intArray = { 1, 2, 4, 5, 6, 8, 22, 34, 56, 0, 8, 8, 1 };
		final List<Integer> list = Arrays.asList(intArray);

		System.out.println(list);
		System.out.println("dublicate elements removed");

		Set<Integer> set = new TreeSet<Integer>(list);
		System.out.println(set);

	}

}
