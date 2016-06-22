package org.farrukh.examples.spring.data.jpa.repository;

import org.farrukh.examples.spring.data.jpa.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
