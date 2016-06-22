package org.farrukh.examples.spring.data.mongodb.repository;

import org.farrukh.examples.spring.data.mongodb.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Responsible for providing access to the base (pre-defined) and custom defined mongodb data manipulation operations (queries) for the Person entity.
 */
public interface PersonRepository extends MongoRepository<Person, String>, PersonRepositoryAdvanced {

    // Demonstrating a so called Query Method technique for retrieving a list of persons from the db.
    /**
     * Returns all persons which matches to given firstName.
     * @param firstName the first name of the a person.
     * @return the list of the persons filtered by given firstName.
     */
    List<Person> findAllByFirstName(final String firstName);

    // Demonstrating JSON Based Query Method technique for retrieving a list of persons from the db.
    /**
     *
     * @param middleName
     * @param age
     * @return
     */
    @Query(value = "{middleName: ?0, age: ?1}")
    List<Person> findByMiddleNameAndAge(final String middleName, final int age);

    @Query(value = "{age: {$gte : ?0}}")
    List<Person> findWhenAgeGraterThen(final int age);

    // Demonstrating JSON Based Query Method technique with a condition.
    @Query("{$or: [{'status': 'DIVORCED'}, {'status': 'UNMARRIED'}]}")
    List<Person> findSinglePersons();

    // Demonstrating JSON Based Query Method technique with a condition and field restrivction.
    @Query("{age: {$gt: ?0}, $or: [{'status': 'DIVORCED'}, {'status': 'UNMARRIED'}]}")
    List<Person> findSinglePersonsConstrainByAge(final int age);

}
