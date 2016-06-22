package org.farrukh.examples.java.collection.general.list.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class RemoveOddElement {

	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<>(Arrays.asList(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }));

		System.out.println("array before removing odd elements: " + array);

		removeOddElement(array);
		removeOddElement2(array);
		System.out.println("array after removing odd elements: " + array);
		Integer[] integerArray = Arrays.copyOf(array.toArray(), array.size(), Integer[].class);
		System.out.println(Arrays.toString(integerArray));
	}

	private static void removeOddElement(ArrayList<Integer> array) {
		Iterator<Integer> itr = array.iterator();
		while (itr.hasNext()) {
			if (itr.next() % 2 == 1) {
				itr.remove();
			}
		}
	}

	private static void removeOddElement2(ArrayList<Integer> array) {
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) % 2 == 1) {
				array.remove(i);
			}
		}
	}
}
