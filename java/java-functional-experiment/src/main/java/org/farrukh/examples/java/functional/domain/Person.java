package org.farrukh.examples.java.functional.domain;

import java.time.LocalDate;

/**
 * Created by Farrukhjon on 08-Oct-15.
 */
public class Person {

    private String name;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int compareByBirthDate(Person a, Person b) {
        return a.birthDate.compareTo(b.birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return !(birthDate != null ? !birthDate.equals(person.birthDate) : person.birthDate != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "birthDate=" + birthDate +
                ", name='" + name + '\'' +
                '}';
    }
}
