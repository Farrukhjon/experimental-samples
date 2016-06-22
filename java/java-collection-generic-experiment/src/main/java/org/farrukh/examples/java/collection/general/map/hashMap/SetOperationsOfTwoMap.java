package org.farrukh.examples.java.collection.general.map.hashMap;

import java.util.HashMap;
import java.util.Map;

public class SetOperationsOfTwoMap {

	public static void main(String[] args) {
		Map<Integer, Double> map1 = initMap(10);
		Map<Integer, Double> map2 = initMap(5);
		System.out.println(map1);
		System.out.println(map2);

		Map<Integer, Double> intersectedMap = intersectMap(map1, map2);
		Map<Integer, Double> unionMap = unionMap(map1, map2);
		System.out.println(intersectedMap);
		System.out.println(unionMap);
	}

	private static Map<Integer, Double> initMap(int n) {
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		for (int i = 0; i < 10; i++) {
			map.put(i, (double) i / n);
		}
		return map;
	}

	private static Map<Integer, Double> intersectMap(Map<Integer, Double> map1, Map<Integer, Double> map2) {
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		for (int key = 0; key < 10; key++) {
			map.put(key, Math.min(map1.get(key), map2.get(key)));
		}
		return map;
	}

	private static Map<Integer, Double> unionMap(Map<Integer, Double> map1, Map<Integer, Double> map2) {
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		for (int key = 0; key < 10; key++) {
			map.put(key, Math.max(map1.get(key), map2.get(key)));
		}
		return map;
	}
}
