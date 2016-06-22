package org.farrukh.examples.java.io.nio;

import java.nio.IntBuffer;

public class BufferBasicDemo {

	public static void main(String[] args) {

		IntBuffer intBuffer = IntBuffer.allocate(10);

		for (int i = 0; i < 10; i++)
			intBuffer.put(i);
		for (int i = 0; i < 10; i++)
			System.out.println(intBuffer.get(i));
		int[] intArray = intBuffer.array();
		for (int i = 0; i < 10; i++)
			System.out.println(intArray[i]);
	}
}
