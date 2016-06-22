package dto;

import java.io.Serializable;

public class Person implements Serializable {

	private long	idPerson;
	private String	surname;
	private String	name;
	private String	patronymic;
	private int		age;
	private Address	address;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	

	public Person(String surname, String name, String patronymic, Address address) {
		super();
		this.surname = surname;
		this.name = name;
		this.patronymic = patronymic;
		this.address = address;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(long idPerson) {
		this.idPerson = idPerson;
	}

}
