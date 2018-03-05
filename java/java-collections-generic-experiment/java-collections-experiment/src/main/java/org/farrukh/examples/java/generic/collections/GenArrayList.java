package org.farrukh.examples.java.generic.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class GenArrayList {

	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("one");
		aList.add("two");
		aList.add("three");

		Iterator<String> iterator = aList.iterator();

		while (iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str + " characters =" + str.length());
		}
	}

}
