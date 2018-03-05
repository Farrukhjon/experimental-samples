package org.farrukh.examples.java.collection.general.set.hashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetInSet {

	public static void main(String[] args) {

		Set<Set<Integer>> dblSet = new HashSet<Set<Integer>>();
		
		dblSet.add(new HashSet<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 })));
		dblSet.add(new HashSet<Integer>(Arrays.asList(new Integer[] { 11, 12, 13, 14, 15, 16, 17, 18, 19, 10 })));
		dblSet.add(new HashSet<Integer>(Arrays.asList(new Integer[] { 21, 22, 23, 24, 25, 26, 27, 28, 29, 20 })));

		Iterator<Set<Integer>> i = dblSet.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

}
