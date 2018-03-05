package org.farrukh.examples.java.collection.general.set.hashSet;

import java.util.HashSet;
import java.util.Set;

public class CheckDuplicateElementsInHashSet {

	public static void main(String[] args) {

		Set<Character> hashSet = new HashSet<Character>();

		hashSet.add('A');
		hashSet.add('B');
		hashSet.add('C');
		hashSet.add('D');
		hashSet.add('X');
		hashSet.add('Z');
		

		char ch = 'A';
		while (ch <= 'Z') {
			if (hashSet.add(ch))
				System.out.println(ch + " = addition success");
			else
				System.out.println(ch + " = addition failed");
			ch++;
		}
	}
}
