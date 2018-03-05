package org.farrukh.examples.java.collection.general.list.linkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BiDirectionalIteration {

	public static void main(String[] args) {
		
		List<String> ll = new LinkedList<String>();
		ll.add("Sunday");
		ll.add("Monday");
		ll.add("Thuesday");
		ll.add("Wendnesday");
		ll.add("Thursday");
		ll.add("Friday");
		ll.add("Saturday");
		
		ListIterator<String> frontIter = ll.listIterator();
		System.out.println("Forward iteration:");
		while (frontIter.hasNext())
			System.out.print(" " + frontIter.next());
		final ListIterator<String> listIterator = ll.listIterator(ll.size());
		System.out.println("\nBackward iteration:");
		while(listIterator.hasPrevious())
			System.out.print(" " + listIterator.previous());
	}

}
