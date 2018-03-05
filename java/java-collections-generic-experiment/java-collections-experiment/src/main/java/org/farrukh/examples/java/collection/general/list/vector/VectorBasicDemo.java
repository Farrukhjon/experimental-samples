package org.farrukh.examples.java.collection.general.list.vector;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorBasicDemo {

	public static void main(String[] args) {

		final String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wendnesday", "Thursday", "Friday", "Saturday" };
		final List<String> daysList = Arrays.asList(days);
		Vector<String> strVec = new Vector<String>(daysList);
		printVector(strVec);
		System.out.println("--------------------------------------------------");

		Iterator<String> iterator = strVec.iterator();

		while (iterator.hasNext()) {
			String s = iterator.next();
			int index = strVec.indexOf(s);
			System.out.println(index);
		}
		System.out.println("--------------------------------------------------");

		Enumeration<String> en = strVec.elements();
		while (en.hasMoreElements()) {
			String s = en.nextElement();
			System.out.println(s);
		}
		System.out.println("--------------------------------------------------");

	}

	private static void printVector(Vector<String> vec) {
		System.out.println(vec);
	}

}
