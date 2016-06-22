package org.farrukh.examples.patterns.enterprise.integration.DAO;

import java.io.Serializable;

/**
 * @author    Farrukhjon SATTOROV
 */
public class User implements Serializable {

	private static final long	serialVersionUID	= 1L;

	/**
	 */
	private int		id;
	/**
	 */
	private String	firstName;
	/**
	 */
	private String	name;
	/**
	 */
	private String	patrpnymic;
	/**
	 */
	private int		age;
	/**
	 */
	private String	course;

	/**
	 * @return
	 * @uml.property  name="age"
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return
	 * @uml.property  name="course"
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @return
	 * @uml.property  name="firstName"
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 * @uml.property  name="patrpnymic"
	 */
	public String getPatrpnymic() {
		return patrpnymic;
	}

	/**
	 * @param  age
	 * @uml.property  name="age"
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param  course
	 * @uml.property  name="course"
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * @param  firstName
	 * @uml.property  name="firstName"
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param  id
	 * @uml.property  name="id"
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param  name
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param  patrpnymic
	 * @uml.property  name="patrpnymic"
	 */
	public void setPatrpnymic(String patrpnymic) {
		this.patrpnymic = patrpnymic;
	}
}
