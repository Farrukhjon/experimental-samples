package org.farrukh.examples.java.collection.general.list.stack;

import java.util.Stack;

public class StackExample {
	
	public static void main(String args[]) {

		Stack<String> stack = new Stack<String>();

		stack.push("Autumnal Tints");
		stack.push("A Week on the Concord and Merrimack Rivers");
		stack.push("The Maine Woods");

		System.out.println("Next: " + stack.peek());

		stack.push("Civil Disobedience, Solitude and Life Without Principle");

		System.out.println(stack.pop());

		stack.push("Walden");
		stack.push("The Natural Man");

		int count = stack.search("The Maine Woods");
		while (count != -1 && count > 1) {
			stack.pop();
			count--;
		}

		System.out.println(stack.pop());
		System.out.println(stack.empty());

	}
}
