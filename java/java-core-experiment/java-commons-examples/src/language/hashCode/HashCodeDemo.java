package language.hashCode;

import java.util.ArrayList;
import java.util.List;

public class HashCodeDemo {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 4; i++) {
			persons.add(new Person());
			System.out.println(persons.get(i).getId());
		}
	}
}
