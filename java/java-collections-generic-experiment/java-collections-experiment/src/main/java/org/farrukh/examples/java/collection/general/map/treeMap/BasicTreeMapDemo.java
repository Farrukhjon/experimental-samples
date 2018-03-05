package org.farrukh.examples.java.collection.general.map.treeMap;

import java.util.TreeMap;

public class BasicTreeMapDemo {

	public static void main(String[] args) {
		TreeMap<String, Integer> decendMap = new TreeMap<>();
		decendMap.put("A", 0);
		decendMap.put("B", 1);
		decendMap.put("C", 3);
		decendMap.put("D", 4);
		decendMap.put("E", 2);
		decendMap.put("F", 11);
		decendMap.put("G", 7);
		decendMap.put("H", 6);
		decendMap.put("I", 9);
		decendMap.put("G", 5);
		
		System.out.println(decendMap);
	}

}
