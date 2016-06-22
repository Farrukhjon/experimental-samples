package org.farrukh.examples.java.collection.general.set.hashSet;

import java.util.HashSet;
import java.util.Set;

public class FindDups {

	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		for (String a : args)
			if (!s.add(a))
				System.out.println("Duplicate detected: " + a);
		System.out.println(s.size() + " distinct words: " + s);
		System.out.println("Set has these elements: " + s);
	}

}
