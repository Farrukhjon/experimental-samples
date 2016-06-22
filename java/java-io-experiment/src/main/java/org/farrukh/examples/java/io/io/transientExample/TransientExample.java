package org.farrukh.examples.java.io.io.transientExample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientExample {

	public static void main(String args[]) throws Exception {

		NameStore nameStore = new NameStore("Steve", "Middle", "Jobs");
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("nameStore"));
		o.writeObject(nameStore);
		o.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("nameStore"));
		NameStore nameStore1 = (NameStore) in.readObject();
		System.out.println(nameStore1);
	}
}
