package org.farrukh.examples.java.collection.general.list.stack;

import java.util.Stack;

public class Reverser {

	private String	input;
	private String	output	= "";

	public Reverser(String input) {
		this.input = input;
	}

	public String reverse() {
		int stackSize = input.length();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < stackSize; i++) {
			Character ch = input.charAt(i);
			stack.push(ch);
		}
		stack.trimToSize();
		while (!stack.isEmpty()) {
			Character ch = stack.pop();
			output += ch;
		}
		return output;
	}

	public static void main(String[] args) {
		Reverser reverser = new Reverser("Hello World!");
		String result = reverser.reverse();
		System.out.println(result);
	}

}
