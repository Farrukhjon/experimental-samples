package org.farrukh.examples.exceptions.runtimeException;

import java.util.ArrayList;
import java.util.List;

public class NullPointerExceptionDemo {

	public static void main(String[] args) {
		List<Integer> list = null;
		try {
			list.add(1);
		} catch (NullPointerException exception) {
			exception.printStackTrace();
		}
		list = new ArrayList<Integer>();
		System.out.println(list.add(null));
		System.out.println(list.add(1));
		System.out.println(list.add(null));
		System.out.println(list);
	}

}
