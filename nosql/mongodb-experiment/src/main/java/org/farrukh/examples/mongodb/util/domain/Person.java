package org.farrukh.examples.mongodb.util.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * @author Farrukh SATTOROV
 * */

@Entity("person")
public class Person {

	@Id	ObjectId		id;

	private String	surname;
	private String	name;
	private String	patronymic;
	private int		age;
	@Embedded
	private Address	address;

	public Person(String surname, String name, String patronymic, int age, Address address) {
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.age = age;
		this.address = address;
	}

	public Person() {
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "surname: " + surname + "name: " + name + " patronymic: " + patronymic + " age: " + age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
