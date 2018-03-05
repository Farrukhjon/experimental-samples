package org.farrukh.examples.java.collection.general.map.hashMap;

import java.util.HashMap;

public class HashcodeOfKeyValue {

	public static void main(String[] args) {

		HashMap<String, String> hashMap = new HashMap<String, String>();

		hashMap.put("Ali", "Book A");
		hashMap.put("Vali", "Book B");
		hashMap.put("Sami", "Book C");
		hashMap.put("Mohi", "Book D");
		hashMap.put("Robvi", "Book E");

		for (String s : hashMap.keySet()) {
			System.out.println("hashCode of " + s + ": " + s.hashCode() + ", hashCode of " + hashMap.get(s) + " " + hashMap.get(s).hashCode());
		}

		HashMap<MyObj, String> hashMap2 = new HashMap<MyObj, String>();

		hashMap2.put(new MyObj(1), "value 1");
		hashMap2.put(new MyObj(2), "value 2");
		hashMap2.put(new MyObj(3), "value 3");
		hashMap2.put(new MyObj(4), "value 4");

		for (MyObj obj : hashMap2.keySet()) {
			System.out.println("hashCode of " + obj + ": " + obj.hashCode());
		}

	}

}
