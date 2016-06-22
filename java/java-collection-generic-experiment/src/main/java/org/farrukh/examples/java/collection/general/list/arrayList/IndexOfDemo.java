package org.farrukh.examples.java.collection.general.list.arrayList;

import java.util.Arrays;
import java.util.List;

public class IndexOfDemo {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Sun", "Mon", "Thu", "Thi", "Fri", "Sat");

		int firstIndexOf = list.indexOf("Fri");

		final int lastIndexOf = list.lastIndexOf("Fri");

		System.out.println(list);
		System.out.println("indexOf(\"Fri\") method: " + firstIndexOf);
		System.out.println("lastIndexOf(\"Fri\") method: " + lastIndexOf);
	}

}
