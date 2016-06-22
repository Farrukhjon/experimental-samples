package org.farrukh.examples.java.collection.general.Iterator;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorDemo {

	public static void main(String[] args) {

		LinkedList<Character> chll = new LinkedList<Character>();

		String alphabet = "abcdefghijklmnopqrstuvwzyx";

		for (char ch : alphabet.toCharArray()) {
			chll.add(ch);
		}

		System.out.println("Input string is: " + chll);

		ListIterator<Character> revIter = chll.listIterator(chll.size());

		while (revIter.hasPrevious()) {
			System.out.printf("%-3s", revIter.previous());
		}
		System.out.println();
		while (revIter.hasNext()) {
			System.out.printf("%-3s", revIter.next());
		}

	}

}
