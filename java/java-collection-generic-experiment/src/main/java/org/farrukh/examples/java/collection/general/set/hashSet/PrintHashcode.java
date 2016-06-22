package org.farrukh.examples.java.collection.general.set.hashSet;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PrintHashcode {

	public static void main(String[] args) {

		Set<String> alphabet = new HashSet<String>();
		Collections.addAll(alphabet, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J");

		for (String e : alphabet) {
			System.out.print(e.hashCode() + "+");
		}
		int hashCode = alphabet.hashCode();
		System.out.println("=" + hashCode);

	}

}
