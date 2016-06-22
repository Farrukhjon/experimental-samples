package org.farrukh.examples.java.collection.general.Iterator;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorReverse {

	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("1");
		aList.add("2");
		aList.add("3");
		aList.add("4");
		aList.add("5");

		ListIterator<String> listIterator = aList.listIterator();

		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}
	}

}
