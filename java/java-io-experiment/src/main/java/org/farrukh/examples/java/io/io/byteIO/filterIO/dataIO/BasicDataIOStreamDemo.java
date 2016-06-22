package org.farrukh.examples.java.io.io.byteIO.filterIO.dataIO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BasicDataIOStreamDemo {

	public static void main(String[] args) {
		String fileName = BasicDataIOStreamDemo.class.getResource("data.txt").getPath();
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(fileName))));
			dos = new DataOutputStream(System.out);
			while (true) {
				char c = dis.readChar();
				dos.writeChar(c);
			}
		} catch (EOFException e) {
			try {
				dis.close();
				dos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
