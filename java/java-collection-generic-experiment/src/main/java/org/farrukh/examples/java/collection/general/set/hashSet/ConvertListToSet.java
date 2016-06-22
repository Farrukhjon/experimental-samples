package org.farrukh.examples.java.collection.general.set.hashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvertListToSet {
	
	public static void main(String[] args) {

		List<String> myList = new ArrayList<String>();
		myList.add("A");
		myList.add("B");
		myList.add("C");
		myList.add("D");

		Set<String> mySet = new HashSet<String>(myList);

		for (Object theObj : mySet)
			System.out.println(theObj);
	}
}
