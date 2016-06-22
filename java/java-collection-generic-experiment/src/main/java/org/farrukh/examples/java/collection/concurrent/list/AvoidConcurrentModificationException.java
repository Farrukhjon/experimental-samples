package org.farrukh.examples.java.collection.concurrent.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AvoidConcurrentModificationException {

	public static void main(String[] args) {

		List<String> list = new CopyOnWriteArrayList<>(Arrays.asList("a", "b", "c"));
		Iterator<String> i = list.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
			list.add("Add");
		}
		System.out.println(list);
	}

}
