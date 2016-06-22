package org.farrukh.examples.java.collection.general.set.hashSet;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {

	public static void main(String[] args) {
		CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>(Arrays.asList(new Integer[] { 1, 2, 2, 3, 3, 4, 4, 1, 5, 6, 7 }));
		System.out.println(copyOnWriteArraySet);

	}
}
