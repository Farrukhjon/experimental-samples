package org.farrukh.examples.java.io.io.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) {
		SerializationBox sb = new SerializationBox();
		serialize("serialFile", sb);
		SerializationBox dSb = (SerializationBox) deSerialize("serialFile");
		System.out.println(dSb.getSerializableProp());
	}

	private static void serialize(String outputFile, Object serializableObject) {
		try {
			FileOutputStream fos = new FileOutputStream(outputFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(serializableObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Object deSerialize(String inputFile) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Object obj = null;
		try {
			fis = new FileInputStream(inputFile);
			ois = new ObjectInputStream(fis);
			obj = ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
}
