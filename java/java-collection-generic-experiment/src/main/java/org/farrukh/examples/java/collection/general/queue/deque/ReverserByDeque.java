package org.farrukh.examples.java.collection.general.queue.deque;

import java.util.ArrayDeque;

public class ReverserByDeque {

	private String	input;

	public ReverserByDeque(String input) {
		this.input = input;
	}

	public String reverse() {
		String output = "";
		int size = input.length();
		ArrayDeque<Character> deque = new ArrayDeque<>(size);
		for (int i = 0; i < size; i++) {
			Character ch = input.charAt(i);
			deque.push(ch);
		}
		while (deque.peek() != null) {
			output += deque.pop();
		}
		return output;
	}

	public static void main(String[] args) {
		ReverserByDeque reverser = new ReverserByDeque("Hello!");
		String result = reverser.reverse();
		System.out.println(result);
	}

}
