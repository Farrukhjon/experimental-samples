package org.farrukh.examples.java.collection.general.queue.deque;

import java.util.ArrayDeque;

public class ArrayDequeDemo {

	public static void main(String[] args) {

		ArrayDeque<Integer> intArrayDeque = new ArrayDeque<Integer>();
		for (int i = 0; i < 16; i++) {
			intArrayDeque.push(i);
		}

		System.out.println(intArrayDeque.peek());// Retrive but don't remove
		System.out.println(intArrayDeque.poll()); //Retrive and remove but not exception
		System.out.println(intArrayDeque.pop()); //Retrive and remove with exception
		System.out.println(intArrayDeque.peek());
	}
}
