package org.farrukh.examples.java.io.io.byteIO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDemo {

	public static void main(String[] args) throws IOException {
		String str = "blah blah";
		byte[] strByte = str.getBytes();
		OutputStream out = new ByteArrayOutputStream();
		out.write(strByte);
		out.close();
	}
}
