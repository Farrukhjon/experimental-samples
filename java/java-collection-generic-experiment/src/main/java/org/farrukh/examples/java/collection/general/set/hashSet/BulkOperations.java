package org.farrukh.examples.java.collection.general.set.hashSet;

import java.util.HashSet;
import java.util.Set;

public class BulkOperations {

	public static void main(String[] args) {

		Set<String> set1 = new HashSet<String>();
		set1.add("A");
		set1.add("B");
		set1.add("C");
		set1.add("D");
		set1.add("E");
		System.out.println("set1:" + set1);

		Set<String> set2 = new HashSet<String>();
		set2.add("A");
		set2.add("F");
		set2.add("B");
		set2.add("G");
		set2.add("K");
		set2.add("X");
		System.out.println("set2:" + set2);
		
		Set<String> union = new HashSet<String>(set1);
		union.addAll(set2);
		System.out.println("1) union set1 and set2: " + union);

		Set<String> intersection = new HashSet<String>(set1);
		intersection.retainAll(set2);
		System.out.println("2) intersection set2 from set1: " + intersection);
		
		Set<String> difference = new HashSet<String>(set1);
		difference.removeAll(set2);
		System.out.println("3) difference between set1 and set2: " + difference);
		
	}

}
