package org.farrukh.examples.java.collection.general.enumeration;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class EnumerateVector {

	public static void main(String args[]) throws Exception {

		Vector<String> v = new Vector<String>();

		v.add("aaa");
		v.add("bbb");
		v.add("ccc");

		Enumeration<String> e = v.elements();
		while (e.hasMoreElements()) {
			Object o = e.nextElement();
			System.out.print(" " + o);
		}

		System.out.println("\nIterator work");

		Iterator<String> iterator = v.iterator();
		while (iterator.hasNext()) {
			System.out.print(" " + iterator.next());
		}
	}
}
