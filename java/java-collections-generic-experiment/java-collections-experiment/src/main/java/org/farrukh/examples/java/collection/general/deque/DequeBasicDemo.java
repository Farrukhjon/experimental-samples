package org.farrukh.examples.java.collection.general.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeBasicDemo {

	public static void main(String[] args) {

		Deque<Integer> intDeque = new ArrayDeque<>();

		intDeque.add(1);
		intDeque.add(2);
		intDeque.add(3);
		intDeque.add(4);
		intDeque.add(5);

		System.out.println(intDeque.peekFirst());
		System.out.println(intDeque.peekLast());

		try {
			System.out.println(intDeque.getFirst());
			System.out.println(intDeque.getLast());
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Iterator<Integer> itr = intDeque.iterator(); while(itr.hasNext()){
		 * System.out.println(intDeque.getFirst()); } */

	}

}
