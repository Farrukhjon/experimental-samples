package org.farrukh.examples.java.collection.general.map.hashMap;

import java.util.HashMap;
import java.util.Map;

public class IterationByKeysByValuesByEntries {

	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<>();

		dic.put("Hello", "Привет");
		dic.put("Hi", "Привет");
		dic.put("Bon appetit", "Приятного аппетиа");

		iterByKeys(dic);
		iterByValues(dic);
		iterByEntries(dic);
	}

	private static void iterByKeys(Map<String, String> map) {
		System.out.println("Iterating by keySet():");
		for (String key : map.keySet()) {
			System.out.printf("%-11s %1s", key, map.get(key) + "\n");
		}
	}

	private static void iterByValues(Map<String, String> map) {
		System.out.println("Iterating by values():");
		for (String value : map.values()) {
			System.out.printf("%-5s", value + "\n");
		}
	}

	private static void iterByEntries(Map<String, String> map) {
		System.out.println("Iterating by entrySet():");
		for (Map.Entry<String, String> es : map.entrySet()) {
			System.out.printf("%-11s %1s", es.getKey(), es.getValue() + "\n");
		}
	}

}
