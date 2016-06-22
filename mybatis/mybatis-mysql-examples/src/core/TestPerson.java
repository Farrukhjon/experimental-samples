package core;

import business.Service;
import dao.PersonDao;
import dto.Address;
import dto.Person;

public class TestPerson {

	public static void main(String[] args) {
		Address address = new Address("Dushanbe", "Saadi 1");
		Person person = new Person("Aliev", "Vali", "Samievich", address);
		PersonDao personDao = (PersonDao) Service.createDao(PersonDao.class);
		personDao.insert(person);
	}

}
