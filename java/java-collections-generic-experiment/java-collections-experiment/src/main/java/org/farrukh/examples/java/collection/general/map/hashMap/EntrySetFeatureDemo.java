package org.farrukh.examples.java.collection.general.map.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EntrySetFeatureDemo {

	private Map<Integer, String>		map;
	private Set<Entry<Integer, String>>	entrySet;

	public EntrySetFeatureDemo() {
		map = new HashMap<>();
		map.put(0, "Zero");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "One");
		map.put(5, "Zero");
		entrySet = map.entrySet();
	}

	public void printMap() {
		System.out.printf("%-10s", "map: " + map + "\n");
	}

	public void printEntrySet() {
		System.out.printf("%-10s", "entrySet = " + entrySet + "\n");
	}

	public void iterateEntrySet() {
		System.out.println("Iterating through entrySet with Map.Entry<Integer, String>:");
		for (Map.Entry<Integer, String> entry : entrySet) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			int hashCode = entry.hashCode();
			System.out.printf("%-7s %-19s %-7s", "getKey() = " + key, "getValue() = " + value, "hashCode() = " + hashCode);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		EntrySetFeatureDemo featureDemo = new EntrySetFeatureDemo();
		featureDemo.printMap();
		featureDemo.printEntrySet();
		featureDemo.iterateEntrySet();
	}

}
