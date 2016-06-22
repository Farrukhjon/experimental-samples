package org.farrukh.examples.java.io.io.byteIO.objectIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIODemo {

	private static final String fileName = "objectFile.dat";

	public static void main(String[] args) {
		Address addressForWrite = new Address("Tajikistan", "Khujand", "Lenin", "1");
		writeObjectToFile(addressForWrite);
		Address addressForRead = (Address) readObjectFromFile(fileName);
		System.out.println(addressForRead);
	}

	private static void writeObjectToFile(Object obj) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Object readObjectFromFile(String fileName) {
		Object obj = null;
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
			obj = ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}

}
