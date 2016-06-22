package org.farrukh.examples.java.collection.general.map.hashMap;

import java.util.HashMap;

public class ConstHashcodeHashMapDemo {

	public static void main(String[] args) {
		HashMap<ConstHashObj, String> map = new HashMap<>();
		map.put(new ConstHashObj(), "first");
		map.put(new ConstHashObj(), "second");
		map.put(new ConstHashObj(), "third");
		System.out.println(map.size());
		System.out.println(map);
	}

}
