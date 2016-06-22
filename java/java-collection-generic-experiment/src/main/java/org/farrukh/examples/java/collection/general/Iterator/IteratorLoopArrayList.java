package org.farrukh.examples.java.collection.general.Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorLoopArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();

		al.add(new Integer(1));
		al.add(new Integer(2));
		al.add(new Integer(3));
		al.add(new Integer(4));
		al.add(new Integer(5));
		al.add(new Integer(6));
		al.add(new Integer(7));
		al.add(new Integer(8));
		al.add(new Integer(9));
		al.add(new Integer(10));

		al.set(5, new Integer(66));

		for (Iterator<Integer> i = al.iterator(); i.hasNext();) {
			Integer integer = (Integer) i.next();
			System.out.println(integer);
		}
	}
}
