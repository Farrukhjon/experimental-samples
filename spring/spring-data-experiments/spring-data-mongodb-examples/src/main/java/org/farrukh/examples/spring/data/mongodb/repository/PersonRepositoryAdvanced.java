package org.farrukh.examples.spring.data.mongodb.repository;

import org.farrukh.examples.spring.data.mongodb.domain.Person;

import java.util.List;

public interface PersonRepositoryAdvanced {

    Person update(final Person person);

    List<Person> find(final int clientNumbers);

}
