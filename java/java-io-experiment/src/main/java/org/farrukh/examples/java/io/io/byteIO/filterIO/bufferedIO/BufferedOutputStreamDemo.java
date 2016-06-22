package org.farrukh.examples.java.io.io.byteIO.filterIO.bufferedIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {

	public static void main(String[] args) {

		BufferedInputStream bis = new BufferedInputStream(System.in);
		BufferedOutputStream bos = new BufferedOutputStream(System.out);
		int value;
		try {
			value = bis.read();
			bos.write(value);
			bos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
