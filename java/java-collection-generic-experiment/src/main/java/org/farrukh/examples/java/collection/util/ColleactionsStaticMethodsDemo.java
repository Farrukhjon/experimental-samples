package org.farrukh.examples.java.collection.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class ColleactionsStaticMethodsDemo {

	public static void main(String[] args) {
		List<String> c = new ArrayList<>();

		Collections.addAll(c, "A", "B", "C");
		System.out.println(c);

		List<String> d = new ArrayList<>(c);
		Collections.copy(d, c);
		System.out.println(d);

		Enumeration<String> enumeration = Collections.enumeration(c);
		while (enumeration.hasMoreElements()) {
			System.out.printf("%-2s", enumeration.nextElement());
		}

		Collections.fill(c, "X");
		System.out.println("\n" + c);

		int frequency = Collections.frequency(c, "X");
		System.out.println("frequency of X in c: " + frequency);

		Enumeration<String> enumerationOfD = Collections.enumeration(d);
		ArrayList<String> arList = Collections.list(enumerationOfD);
		System.out.println(arList);

		Collections.reverse(arList);
		System.out.println(arList);

		Collections.sort(arList);
		System.out.println(arList);
	}

}
