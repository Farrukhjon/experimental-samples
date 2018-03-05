package org.farrukh.examples.java.collection.general.array;

import java.util.Arrays;

public class CheckContainsElementOfArray {

	public static void main(String[] args) {
		String[] a = { "one", "two", "three" };
		boolean contains = Arrays.asList(a).contains("two");
		System.out.println(contains);
		contains = Arrays.asList(a).contains("four");
		System.out.println(contains);
	}

}
