package org.farrukh.examples.java.collection.general.list.linkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GetSubList {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
		LinkedList<Integer> lList = new LinkedList<Integer>(list);

		List<Integer> subList = lList.subList(3, 6);
		System.out.println(subList);
	}
}
