package org.farrukh.examples.java.io.io.byteIO.objectIO;

import java.io.Serializable;

public class Address implements Serializable {

	private String country;
	private String city;
	private String street;
	private String phone;

	public Address() {
	}

	public Address(String country, String city, String street, String phone) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return country + ", " + city + ", " + street + ".";
	}

}
