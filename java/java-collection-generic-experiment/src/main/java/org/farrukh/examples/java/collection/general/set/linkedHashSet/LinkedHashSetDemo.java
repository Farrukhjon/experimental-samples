package org.farrukh.examples.java.collection.general.set.linkedHashSet;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

	public static void main(String[] args) {

		LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<Character>();
		
		//Collections.addAll(linkedHashSet, 'f', 'b', 'e', 'd', 'c', 'a');
		
		linkedHashSet.add('f');
		linkedHashSet.add('b');
		linkedHashSet.add('e');
		linkedHashSet.add('d');
		linkedHashSet.add('c');
		linkedHashSet.add('a');

		System.out.println(linkedHashSet);
	}

}
