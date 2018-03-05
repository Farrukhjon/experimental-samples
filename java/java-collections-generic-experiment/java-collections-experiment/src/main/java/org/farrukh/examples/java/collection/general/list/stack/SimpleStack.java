package org.farrukh.examples.java.collection.general.list.stack;

import java.util.Stack;

public class SimpleStack {

	public static void main(String[] args) {

		Stack<Integer> intStack = new Stack<Integer>();
		
		intStack.push(0);
		intStack.push(1);
		intStack.push(2);
		intStack.push(3);
		intStack.push(4);

		int count = intStack.size();

		while (count > 0) {
			int element = intStack.pop();
			System.out.println(element);
			count = intStack.size();
		}

	}

}
