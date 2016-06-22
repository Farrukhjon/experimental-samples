package org.farrukh.examples.java.collection.general.list.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExceptionDemo {

	public static void main(String args[]) {
		List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
		Iterator<String> i = list.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
			try {
				list.add("Add"); // comodification occured
			} catch (ConcurrentModificationException e) {
				e.printStackTrace();
			}
		}
	}
}
