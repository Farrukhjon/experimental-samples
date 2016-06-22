package org.farrukh.examples.java.collection.general.map.treeMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapOnKeyInteger {

	public static void main(String[] args) {

		Map<Integer, String> unsortMap = new HashMap<Integer, String>();
		unsortMap.put(10, "z");
		unsortMap.put(5, "b");
		unsortMap.put(6, "a");
		unsortMap.put(20, "c");
		unsortMap.put(1, "d");
		unsortMap.put(7, "e");
		unsortMap.put(8, "y");
		unsortMap.put(99, "n");
		unsortMap.put(50, "j");
		unsortMap.put(2, "m");
		unsortMap.put(9, "f");

		System.out.println("Unsort Map......");
		printMap(unsortMap);

		System.out.println("\nSorted Map......");
		Map<Integer, String> treeMap = new TreeMap<Integer, String>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}

		});
		treeMap.putAll(unsortMap);

		printMap(treeMap);

	}

	public static void printMap(Map<Integer, String> map) {
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
	}
}
