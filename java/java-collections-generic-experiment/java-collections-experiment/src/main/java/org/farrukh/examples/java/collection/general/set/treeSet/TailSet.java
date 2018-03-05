package org.farrukh.examples.java.collection.general.set.treeSet;

import java.util.SortedSet;
import java.util.TreeSet;

public class TailSet {
	public static void main(String[] args) {
		TreeSet<String> teeSet = new TreeSet<String>();

		teeSet.add("1");
		teeSet.add("2");
		teeSet.add("3");
		teeSet.add("5");
		teeSet.add("4");

		SortedSet<String> sortedSet = teeSet.tailSet("2");
		System.out.println("Tail Set Contains : " + sortedSet);
		sortedSet.clear();
	}
}
