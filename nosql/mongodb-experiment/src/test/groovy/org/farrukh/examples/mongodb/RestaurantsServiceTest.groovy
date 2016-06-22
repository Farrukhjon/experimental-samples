package org.farrukh.examples.mongodb

import org.farrukh.examples.mongodb.restaurants.RestaurantsServiceImpl
import spock.lang.Specification
import spock.lang.Subject

class RestaurantsServiceTest extends Specification {

    @Subject
    def restaurants = new RestaurantsServiceImpl()

    def 'exercise searching all restaurants'() {
        when:
        def result = restaurants.getAll()

        then:
        result
    }

}
