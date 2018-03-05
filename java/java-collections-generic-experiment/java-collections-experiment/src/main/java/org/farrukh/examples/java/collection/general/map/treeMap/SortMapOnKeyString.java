package org.farrukh.examples.java.collection.general.map.treeMap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapOnKeyString {

	public static void main(String[] args) {
		 
		Map<String, String> unsortMap = new HashMap<String, String>();
		unsortMap.put("Z", "z");
		unsortMap.put("B", "b");
		unsortMap.put("A", "a");
		unsortMap.put("C", "c");
		unsortMap.put("D", "d");
		unsortMap.put("E", "e");
		unsortMap.put("Y", "y");
		unsortMap.put("N", "n");
		unsortMap.put("J", "j");
		unsortMap.put("M", "m");
		unsortMap.put("F", "f");
 
		System.out.println("Unsort Map......");
		printMap(unsortMap);
 
		System.out.println("\nSorted Map......");
		Map<String, String> treeMap = new TreeMap<String, String>(unsortMap);
		printMap(treeMap);
 
	}
 
	public static void printMap(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() 
                                      + " Value : " + entry.getValue());
		}
	}
}
