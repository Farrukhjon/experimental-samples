package org.farrukh.examples.exceptions.runtimeException;

public class ClassCastExceptionDemo {

	public static void main(String[] args) {

		Object obj = new Integer(0);
		String str = (String) obj;
	}

}
