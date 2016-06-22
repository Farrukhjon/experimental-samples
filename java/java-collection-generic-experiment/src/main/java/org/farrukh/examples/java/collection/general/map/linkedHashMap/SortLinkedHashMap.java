package org.farrukh.examples.java.collection.general.map.linkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortLinkedHashMap {

	public static void main(String[] args) {

		Map<String, Integer> map = new LinkedHashMap<>();

		map.put("X", 0);
		map.put("D", 1);
		map.put("F", 2);
		map.put("A", 3);
		map.put("S", 4);

		System.out.println("map: " + map);

		Map<String, Integer> sortedMap = new TreeMap<>(map);

		System.out.println("sortedMap: " + sortedMap);

		map = sortedMap;
		System.out.println("map: " + map);

	}

}
