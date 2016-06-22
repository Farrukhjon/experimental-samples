package org.farrukh.examples.java.collection.general.set.hashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasicHashSetDemo {

	public static void main(String[] args) {

		List<String> col = Arrays.asList("A", "B", "C", "D", "E");
		Set<String> set = new HashSet<>(col);
		System.out.println(set);

	}

}
