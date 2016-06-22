package org.farrukh.examples.spring.data.mongodb.repository

import org.farrukh.examples.spring.data.mongodb.BaseTest
import org.farrukh.examples.spring.data.mongodb.domain.Address
import org.farrukh.examples.spring.data.mongodb.domain.Person
import org.springframework.beans.factory.annotation.Autowired

import static org.farrukh.examples.spring.data.mongodb.domain.Gender.FEMALE
import static org.farrukh.examples.spring.data.mongodb.domain.Gender.FEMALE
import static org.farrukh.examples.spring.data.mongodb.domain.Gender.MALE
import static org.farrukh.examples.spring.data.mongodb.domain.Gender.MALE
import static org.farrukh.examples.spring.data.mongodb.domain.Gender.MALE
import static org.farrukh.examples.spring.data.mongodb.domain.Status.DIVORCED
import static org.farrukh.examples.spring.data.mongodb.domain.Status.MARRIED
import static org.farrukh.examples.spring.data.mongodb.domain.Status.MARRIED
import static org.farrukh.examples.spring.data.mongodb.domain.Status.UNMARRIED
import static org.farrukh.examples.spring.data.mongodb.domain.Status.UNMARRIED

/**
 * Created by Farrukhjon on 5/26/15.
 */
class PersonRepositoryIntegrationTests extends BaseTest {

    @Autowired
    PersonRepository repository

    def setup() {
        repository.deleteAll()
    }

    def 'should test bulk saving of the persons and its addresses'() {
        given:
        def addresses = [new Address(country: 'Tajikistan', city: 'Khujand', street: 'Firdavsi', number: 10),
                         new Address(country: 'Tajikistan', city: 'Dushanbe', street: 'Rudaki', number: 17)]
        def persons = [new Person(middleName: 'Vali', addresses: addresses),
                       new Person(middleName: 'Ali', addresses: addresses),
                       new Person(middleName: 'Sami', addresses: addresses),
                       new Person(middleName: 'Homi', addresses: addresses)
        ]

        when:
        def savedPersons = repository.save(persons)

        then:
        savedPersons
    }

    def 'exercise experimenting update via findOne and save methods'() {
        given: 'some data for saving, getting and updating'
        def addresses = [new Address(country: 'Tajikistan', city: 'Khujand', street: 'Firdavsi', number: 10)]
        def oldName = 'Vali'
        def newName = 'Salim'
        def person = new Person(middleName: oldName, addresses: addresses)

        when: 'the firs saving is invoked'
        def firstSavedPersons = repository.save(person)

        and: 'the person by specified id is retrieved'
        def retriedForChangePerson = repository.findOne(firstSavedPersons.id)

        and: 'the middleName is changed and changedPerson to the database'

        retriedForChangePerson.middleName = newName
        def changedPerson = repository.save(retriedForChangePerson)

        then: 'the first changedPerson id and '
        changedPerson.id == firstSavedPersons.id
        firstSavedPersons.middleName == oldName
        changedPerson.middleName == newName
    }

    def 'exercise getting all persons by their first name'() {
        given:
        def addresses = [new Address(country: 'Tajikistan', city: 'Khujand', street: 'Firdavsi', number: 10)]
        def persons = [
                new Person(firstName: 'Ali', middleName: 'Valiev', lastName: 'Samievich', age: 25, addresses: addresses),
                new Person(firstName: 'Homid', middleName: 'Teshaev', lastName: 'Umedovich', age: 35, addresses: addresses),
                new Person(firstName: 'Goib', middleName: 'Sangov', lastName: 'Azamovich', age: 31, addresses: addresses),
                new Person(firstName: 'Ali', middleName: 'Nematov', lastName: 'Hasanovich', age: 21, addresses: addresses),
                new Person(firstName: 'Salim', middleName: 'Hojiev', lastName: 'Murodovich', age: 50, addresses: addresses),
        ]

        and:
        repository.save(persons)

        when:
        def results = repository.findAllByFirstName('Ali')

        then:
        results.size() == 2
        results[0].firstName == 'Ali'
        results[0].middleName == 'Valiev'
        results[0].lastName == 'Samievich'
        results[0].age == 25

        and:
        results[1].firstName == 'Ali'
        results[1].middleName == 'Nematov'
        results[1].lastName == 'Hasanovich'
        results[1].age == 21
    }

    def 'exercise getting all persons by their middle ane and age'() {
        given:
        def addresses = [new Address(country: 'Tajikistan', city: 'Khujand', street: 'Firdavsi', number: 10)]
        def persons = [
                new Person(firstName: 'Ali', middleName: 'Valiev', lastName: 'Samievich', age: 25, addresses: addresses),
                new Person(firstName: 'Homid', middleName: 'Sangov', lastName: 'Umedovich', age: 35, addresses: addresses),
                new Person(firstName: 'Goib', middleName: 'Sangov', lastName: 'Azamovich', age: 35, addresses: addresses),
                new Person(firstName: 'Ali', middleName: 'Nematov', lastName: 'Hasanovich', age: 21, addresses: addresses),
                new Person(firstName: 'Salim', middleName: 'Hojiev', lastName: 'Murodovich', age: 50, addresses: addresses),
        ]

        and:
        repository.save(persons)

        when:
        def results = repository.findByMiddleNameAndAge('Sangov', 35)

        then:
        results.size() == 2
        results[0].firstName == 'Homid'
        results[0].middleName == 'Sangov'
        results[0].lastName == 'Umedovich'
        results[0].age == 35

        and:
        results[1].firstName == 'Goib'
        results[1].middleName == 'Sangov'
        results[1].lastName == 'Azamovich'
        results[1].age == 35
    }

    def 'exercise getting all persons whe age grater then'() {
        given:
        def addresses = [new Address(country: 'Tajikistan', city: 'Khujand', street: 'Firdavsi', number: 10)]
        def persons = [
                new Person(firstName: 'Ali', middleName: 'Valiev', lastName: 'Samievich', age: 25, addresses: addresses),
                new Person(firstName: 'Homid', middleName: 'Sangov', lastName: 'Umedovich', age: 35, addresses: addresses),
                new Person(firstName: 'Goib', middleName: 'Sangov', lastName: 'Azamovich', age: 35, addresses: addresses),
                new Person(firstName: 'Ali', middleName: 'Nematov', lastName: 'Hasanovich', age: 21, addresses: addresses),
                new Person(firstName: 'Salim', middleName: 'Hojiev', lastName: 'Murodovich', age: 50, addresses: addresses),
        ]

        and:
        repository.save(persons)

        when:
        def results = repository.findWhenAgeGraterThen(30)

        then:
        results.size() == 3
    }

    def 'exercise update person age by its last name'() {
        given:
        def ali = new Person(firstName: 'Ali', middleName: 'Valiev', lastName: 'Samievich', age: 25)

        when:
        def save = repository.save(ali)

        then:
        save.age == 25

        when:
        save.setAge(30)
        repository.update(ali)

        and:
        def one = repository.findOne(save.id)

        then:
        one.age == 30
    }

    def 'exercise finding single person which are singles'() {
        given:
        def persons = [
                new Person(firstName: 'Ali', middleName: 'Valievich', lastName: 'Samiev', age: 20, gender: MALE, addresses: [ new Address(country: 'Tajikistan', city: 'Khujand')], status: MARRIED),
                new Person(firstName: 'Ali', middleName: 'Hasanovich', lastName: 'Komilov', age: 25, gender: MALE, addresses: [ new Address(country: 'Tajikistan', city: 'Dushanbe')], status: UNMARRIED),
                new Person(firstName: 'Surayo', middleName: 'Homidovna', lastName: 'Umarova', age: 30, gender: FEMALE, addresses: [ new Address(country: 'Tajikistan', city: 'Kulob')], status: UNMARRIED),
                new Person(firstName: 'Gulru', middleName: 'Valievich', lastName: 'Samiev', age: 27, gender: FEMALE, addresses: [ new Address(country: 'Uzbelistan', city: 'Bukhoro')], status: MARRIED),
                new Person(firstName: 'Ali', middleName: 'Rustamovich', lastName: 'Suhrobov', age: 29, gender: MALE, addresses: [ new Address(country: 'Tajikistan', city: 'Dushanbe')], status: DIVORCED),
        ]
        mongoTemplate.insertAll(persons)

        when:
        def singlePersons = repository.findSinglePersons()

        then:
        singlePersons.size() == 3
    }

    def 'exercise finding single person which are singles and constrain by age'() {
        given:
        def age = 20
        def persons = [
                new Person(firstName: 'Ali', middleName: 'Valievich', lastName: 'Samiev', age: 20, gender: MALE, addresses: [ new Address(country: 'Tajikistan', city: 'Khujand')], status: MARRIED),
                new Person(firstName: 'Ali', middleName: 'Hasanovich', lastName: 'Komilov', age: 20, gender: MALE, addresses: [ new Address(country: 'Tajikistan', city: 'Dushanbe')], status: UNMARRIED),
                new Person(firstName: 'Surayo', middleName: 'Homidovna', lastName: 'Umarova', age: 30, gender: FEMALE, addresses: [ new Address(country: 'Tajikistan', city: 'Kulob')], status: UNMARRIED),
                new Person(firstName: 'Gulru', middleName: 'Valievich', lastName: 'Samiev', age: 27, gender: FEMALE, addresses: [ new Address(country: 'Uzbelistan', city: 'Bukhoro')], status: MARRIED),
                new Person(firstName: 'Ali', middleName: 'Rustamovich', lastName: 'Suhrobov', age: 29, gender: MALE, addresses: [ new Address(country: 'Tajikistan', city: 'Dushanbe')], status: DIVORCED),
        ]
        mongoTemplate.insertAll(persons)

        when:
        def singlePersons = repository.findSinglePersonsConstrainByAge(age)

        then:
        singlePersons.size() == 2
    }


}
