package org.farrukh.examples.java.collection.general.Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class IterateCollectionUsingIterator {
	public static void main(String[] args) {

		ArrayList<String> aList = new ArrayList<String>();

		aList.add("1");
		aList.add("2");
		aList.add("3");
		aList.add("4");
		aList.add("5");

		Iterator<String> itr = aList.iterator();

		// iterate through the ArrayList values using Iterator's hasNext and
		// next methods

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
