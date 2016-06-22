package org.farrukh.examples.java.collection.general.set.treeSet;

import java.util.SortedSet;
import java.util.TreeSet;

public class SubSet {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();

		treeSet.add("1");
		treeSet.add("2");
		treeSet.add("3");
		treeSet.add("4");
		treeSet.add("5");

		SortedSet<String> sortedSet = treeSet.subSet("2", "5");

		System.out.println("SortedSet Contains : " + sortedSet);
	}
}
