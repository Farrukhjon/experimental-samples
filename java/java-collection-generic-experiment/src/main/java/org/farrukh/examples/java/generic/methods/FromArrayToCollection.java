package org.farrukh.examples.java.generic.methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FromArrayToCollection {

	public static void main(String[] args) {
		Integer[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println("array: " + Arrays.toString(a));
		List<Integer> list = new ArrayList<Integer>();
		fromArrayToCollection(a, list);
		System.out.println("list: " + list);

	}

	private static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
		for (T t : a)
			c.add(t);
	}

	/*private static <T> void fromArrayToCollection(Object[] a, Collection<?> c) { //Incorrect method
		for (Object obj : a)
			c.add(obj);
	}*/

}
