package org.farrukh.examples.java.collection.general.list.arrayList;

import java.util.ArrayList;
import java.util.List;

public class RetainAllDemo {

	public static void main(String[] args) {

		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(11);
		l1.add(12);
		l1.add(21);
		l1.add(31);
		System.out.println("l1:" + l1);

		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(11);
		l2.add(21);
		l2.add(33);
		l2.add(31);
		l2.add(43);
		System.out.println("l2:" + l2);

		System.out.println("is equal?: " + l1.equals(l2));

		l1.retainAll(l2);
		System.out.println("l1 after retainAll:" + l1);
		l2.retainAll(l1);
		System.out.println("l2 after retainAll:" + l2);

		System.out.println("is equal?: " + l1.equals(l2));

	}

}
