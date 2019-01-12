package org.farrukh.examples.exceptions.runtimeException;

/**
 * IndexOutOfBoundsException is a runtime exception that’s thrown when a
 * piece of code tries to access a list position that’s out of its bounds—when the
 * position is either less than 0 or greater than or equal to the list’s size.
 * */

public class ArrayIndexOutOfBoundsExceptionDemo {

	public static void main(String[] args) {

		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int element = a[-1]; // throw ArrayIndexOutOfBoundsException
		element = a[a.length];
		element = a[a.length + 1];
		System.out.println(element);
		
	}

}
