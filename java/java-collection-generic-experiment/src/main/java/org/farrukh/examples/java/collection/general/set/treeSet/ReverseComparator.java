package org.farrukh.examples.java.collection.general.set.treeSet;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ReverseComparator {

	public static void main(String args[]) throws Exception {
		
		String elements[] = { "A", "C", "D", "E", "F" };

		Set<String> set = new TreeSet<String>(Collections.reverseOrder());
		for (int i = 0, n = elements.length; i < n; i++) {
			set.add(elements[i]);
		}
		
		System.out.println(set);
	}
}
