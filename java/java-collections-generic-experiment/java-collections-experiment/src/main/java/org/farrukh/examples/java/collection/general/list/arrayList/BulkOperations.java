package org.farrukh.examples.java.collection.general.list.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BulkOperations {

	public static void main(String[] args) {

		List<Integer> a = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		List<Integer> b = new ArrayList<Integer>(Arrays.asList(0, 2, 3, 4, 5, 6, 7, 10, 11, 12));
		System.out.println("Print two lists:");
		System.out.println("a: " + a);
		System.out.println("b: " + b);

		System.out.println("a.addAll(b):");
		a.addAll(b);
		System.out.println("a: " + a);
		System.out.println("b: " + b);

		System.out.println("a.removeAll(b):");
		a.removeAll(b);
		System.out.println("a: " + a);
		System.out.println("b: " + b);

		System.out.println("a.retainAll(b):");
		a.retainAll(b);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}

}
