package org.farrukh.examples.java.collection.general.set.hashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayOfHashSet {

	public static void main(String[] args) {
	
		Set<String>[] ahs = new HashSet[10];

		for (int i = 0; i <= 4; i++) {
			ahs[i] = new HashSet<>();
		}
		ahs[0].add("A");
		ahs[0].add("B");
		ahs[0].add("B"); // attemping add dublicate B

		ahs[1].add("C");
		ahs[1].add("D");
		ahs[1].add("E");

		ahs[2].add("F");
		ahs[3].add("G");

		ahs[4].add("H");
		ahs[4].add("I");
		ahs[4].add("J");

		System.out.println(Arrays.toString(ahs));
	}

}
