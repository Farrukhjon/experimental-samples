package org.farrukh.examples.spring.data.mongodb

import org.farrukh.examples.spring.data.mongodb.domain.Address
import org.farrukh.examples.spring.data.mongodb.domain.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import static org.farrukh.examples.spring.data.mongodb.domain.Gender.FEMALE
import static org.farrukh.examples.spring.data.mongodb.domain.Gender.MALE
import static org.farrukh.examples.spring.data.mongodb.domain.Status.*

/**
 * Created by Farrukhjon on 5/26/15.
 */
@ContextConfiguration(classes = Application, loader = SpringApplicationContextLoader)
class BaseTest extends Specification {

    @Autowired
    MongoOperations mongoTemplate

    def setup() {
        def persons = [
                new Person(firstName: 'Ali', middleName: 'Valievich', lastName: 'Samiev', age: 20, gender: MALE, addresses: [ new Address(country: 'Tajikistan', city: 'Khujand')], status: MARRIED),
                new Person(firstName: 'Ali', middleName: 'Hasanovich', lastName: 'Komilov', age: 25, gender: MALE, addresses: [ new Address(country: 'Tajikistan', city: 'Dushanbe')], status: UNMARRIED),
                new Person(firstName: 'Surayo', middleName: 'Homidovna', lastName: 'Umarova', age: 30, gender: FEMALE, addresses: [ new Address(country: 'Tajikistan', city: 'Kulob')], status: UNMARRIED),
                new Person(firstName: 'Gulru', middleName: 'Valievich', lastName: 'Samiev', age: 27, gender: FEMALE, addresses: [ new Address(country: 'Uzbelistan', city: 'Bukhoro')], status: MARRIED),
                new Person(firstName: 'Ali', middleName: 'Rustamovich', lastName: 'Suhrobov', age: 29, gender: MALE, addresses: [ new Address(country: 'Tajikistan', city: 'Dushanbe')], status: DIVORCED),
        ]
        mongoTemplate.insertAll(persons)
    }

    def cleanup() {
        mongoTemplate.dropCollection(Person)
    }

}
