package org.farrukh.examples.spring.data.jpa

import org.farrukh.examples.spring.data.jpa.domain.Person
import org.farrukh.examples.spring.data.jpa.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = Application, loader = SpringApplicationContextLoader)
class PersonRepositoryTest extends Specification {

    @Autowired
    PersonRepository repository

    def setup() {
        assert repository
        repository.deleteAll();
    }

    def 'exercise storing persons to the database'() {
        given: 'expected data'
        def expectedId = 1L
        def expectedFirstName = 'Ali'
        def expectedMiddleName = 'Vali'
        def expectedLastName = 'Sami'

        and: 'the person is created using expected data'
        def person = new Person(firstName: expectedFirstName, middleName: expectedMiddleName, lastName: expectedLastName)

        when: 'the save operation is called'
        def savedPerson = repository.save(person)

        then: 'expected results are returned'
        savedPerson.id == expectedId
        savedPerson.firstName == expectedFirstName
        savedPerson.middleName == expectedMiddleName
        savedPerson.lastName == expectedLastName
    }

}
