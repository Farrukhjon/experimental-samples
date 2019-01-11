package org.farrukh.examples.exceptions.runtimeException;

import java.util.ArrayList;
import java.util.List;

public class AvoidClassCastException {

	public static void main(String[] args) {
		
		List<Object> list = new ArrayList<Object>();
		
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(3));
		
		list.add(new String("hello"));
		list.add(new String("java"));
		list.add(new String("world!"));

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Integer) {
				Integer val = (Integer) list.get(i);
				System.out.println(val);
			}
			if (list.get(i) instanceof String) {
				String str = (String) list.get(i);
				System.out.println(str);
			}
		}
	}

}
