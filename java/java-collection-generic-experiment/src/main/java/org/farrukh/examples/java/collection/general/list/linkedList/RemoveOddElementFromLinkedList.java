package org.farrukh.examples.java.collection.general.list.linkedList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class RemoveOddElementFromLinkedList {

	public static void main(String[] args) {

		LinkedList<String> bookList = new LinkedList<>(Arrays.asList(new String[] { "Java", "CSS", "HTML", "MySQL", "JavaScript" }));

		System.out.println(bookList);

		removeOddElement(bookList);

		System.out.println(bookList);
		
	}

	private static void removeOddElement(LinkedList<String> list) {
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			final int index = list.indexOf(iter.next());
			if (index % 2 == 1) {
				iter.remove();
			}
		}
	}

}
