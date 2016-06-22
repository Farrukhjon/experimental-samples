package org.farrukh.examples.algorithms.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GenPersonDB {

	public static void main(String[] args) throws IOException {

		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 100; i++) {
			int id = i + 1;
			Person person = new Person(id, "surname" + id, "name" + id, "patronymic" + id);
			persons.add(person);
		}

		File personDB = new File("personDB.txt");
		personDB.createNewFile();

		Writer out = new FileWriter(personDB);

		BufferedWriter writer = new BufferedWriter(out);
		try {
			for (Person person : persons) {
				writer.write(String.valueOf(person.getId()) + "\t");
				writer.write(person.getSurname() + "\t");
				writer.write(person.getName() + "\t");
				writer.write(person.getPatronymic() + "\t");
				writer.write("\n");
			}
		} finally {
			writer.flush();
			writer.close();
			out.close();
		}
	}

}
