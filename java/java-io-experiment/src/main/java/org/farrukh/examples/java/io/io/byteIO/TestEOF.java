package org.farrukh.examples.java.io.io.byteIO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {

	public static void main(String[] args) {

		try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("myFile.txt")))) {
			while (dis.available() > 0) {
				char ch = (char) dis.readByte();
				if(ch == '\r')
					System.out.println("\\r");
				if(ch == '\n')
					System.out.println("\\n");
				System.out.print(ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
