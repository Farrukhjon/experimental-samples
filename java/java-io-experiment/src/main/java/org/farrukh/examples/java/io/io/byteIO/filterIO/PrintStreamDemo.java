package org.farrukh.examples.java.io.io.byteIO.filterIO;

import java.io.PrintStream;

public class PrintStreamDemo {

	public static void main(String[] args) {
		String strData = "0123456789abcdefghijklmnopqrstuvwxyz";
		byte[] bytes = strData.getBytes();
		PrintStream printStream = new PrintStream(System.out);
		for (byte b : bytes) {
			printStream.print((char) b);
			printStream.print("=");
			printStream.print(b);
			printStream.println();
		}
	}

}
