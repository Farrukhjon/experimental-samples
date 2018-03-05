package org.farrukh.examples.java.collection.general.array;

import java.util.Arrays;

public class IsAElementsInArray {

	public static void main(String[] args) {
		Object[] obj = new Object[10];
		for (int i = 0, n = obj.length; i < n; i++) {
			if (i <= 3)
				obj[i] = new String("str" + i);
			else if (i <= 6)
				obj[i] = new Double(i);
			else
				obj[i] = new Integer(i);
		}
		System.out.println(Arrays.toString(obj));
	}
}
