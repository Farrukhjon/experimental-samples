package org.farrukh.examples.exceptions.runtimeException;

/**
 * ArrayIndexOutOfBoundsException is a runtime exception that’s thrown when
 * a piece of code tries to access an array position out of its bounds—when an
 * array is accessed either at a position less than 0 or at a position greater than or
 * equal to its length.
 * */

import java.util.ArrayList;
import java.util.List;

public class IndexOutOfBoundsExceptionDemo {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		final int size = list.size();
		Integer element = list.get(size); // if (index >= size) throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		System.out.println(element);
	}

}
