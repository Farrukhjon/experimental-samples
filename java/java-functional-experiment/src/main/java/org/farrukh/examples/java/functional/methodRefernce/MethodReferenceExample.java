package org.farrukh.examples.java.functional.methodRefernce;

import org.farrukh.examples.java.functional.domain.Person;

import static java.util.Arrays.sort;

/**
 * Created by Farrukhjon on 18-Sep-15.
 */
public class MethodReferenceExample {

    public void sortPersonByItsBirthDateUsingMethodReference(Person[] persons) {
        sort(persons, Person::compareByBirthDate);
    }

}
