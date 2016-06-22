package org.farrukh.examples.spring.boot.jackson.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Farrukhjon on 03-Oct-15.
 */
public class Person {

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String name;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private int age;

    @JsonProperty
    private Date birthDate;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
