package org.farrukh.examples.spring.data.mongodb

import org.farrukh.examples.spring.data.mongodb.domain.Person
import org.farrukh.examples.spring.data.mongodb.domain.stat.Stat
import org.springframework.data.mongodb.core.aggregation.Aggregation

class AggregationExamples extends BaseTest {

    def 'exercise counting fields'() {
        given:
        def agg = Aggregation.newAggregation(
                Aggregation.project('gender', 'firstName', 'addresses'),
                Aggregation.group('gender', 'firstName', 'addresses').count().as('count')
                //Aggregation.group('gender').addToSet('gender').as('gender').count().as('count')
        )

        when:
        def results = mongoTemplate.aggregate(agg, Person, Stat).getMappedResults()

        then:
        results
    }

}
