package org.farrukh.examples.java.functional.domain;

/**
 * Created by Farrukhjon on 05-Oct-15.
 */
public class Employee {

    private int id;
    private String firstName;
    private String name;
    private String lastName;
    private int age;
    private Department department;

    public Employee() {
    }

    public Employee( int id, String firstName, String name, String lastName, int age, Department department) {
        this.age = age;
        this.department = department;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
