package org.farrukh.examples.java.collection.general.list.stack;

import java.util.Stack;

public class StackBasicDemo {

	public static void main(String[] args) {

		Stack<Character> charStack = new Stack<>();

		System.out.println("push " + charStack.push('a'));
		System.out.println("push " + charStack.push('b'));
		System.out.println("push " + charStack.push('c'));

		System.out.println("pop " + charStack.pop());
		System.out.println("top " + charStack.peek());

		System.out.println("push " + charStack.push('d'));

		System.out.println("The charStack now has " + charStack.size() + " elements: " + charStack);

		System.out.println("Here are the contents of the stack, from top to bottom:");
		for (int i = charStack.size() - 1; i >= 0; i--)
			System.out.print("index" + i + " = " + charStack.get(i) + " ");

		System.out.println("\nHere are the contents of the stack, starting from index 0:");
		for (Character c : charStack)
			System.out.print(c + " ");

		System.out.println("\nHere are the contents of the stack using pop() method:");
		while (!charStack.isEmpty())
			System.out.print(charStack.pop() + " ");

	}
}
