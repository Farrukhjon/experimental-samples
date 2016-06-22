package org.farrukh.examples.java.collection.general.list.linkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GetFirstLast {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
		
		LinkedList<Integer> list = new LinkedList<Integer>(numbers);

		System.out.println("First element of LinkedList: " + list.getFirst());
		System.out.println("Last element of LinledList: " + list.getLast());
	}
}
