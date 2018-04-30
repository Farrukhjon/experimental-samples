package org.farrukh.examples.mongodb.morphia.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("entity")
public class Employee {

	@Id
	private ObjectId id;
	
	private String name;
	private String position;
	
	@Embedded
	private Deportament deportament;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Deportament getDeportament() {
		return deportament;
	}
	public void setDeportament(Deportament deportament) {
		this.deportament = deportament;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
