package org.farrukh.examples.spring.data.mongodb

import org.farrukh.examples.spring.data.mongodb.domain.Person
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.AggregationResults

import static org.springframework.data.mongodb.core.aggregation.Aggregation.project

class MongoTemplateExamples extends BaseTest {


    def rand = new Random()
    def randoms = []
    def setup() {
        mongoTemplate.getCollection('persons').drop()
        10.times {
            def randFirstName = UUID.randomUUID().toString().substring(0, 7)
            def randMiddleName = UUID.randomUUID().toString().substring(0, 7)
            def randLastName = UUID.randomUUID().toString().substring(0, 7)
            def randClientNum = rand.ints(100, 1000).findFirst().asInt
            randoms << randClientNum
            def peron = new Person(firstName: randFirstName, middleName: randMiddleName, lastName: randLastName, clientNums: randoms)
            mongoTemplate.insert(peron)
        }
    }


    def 'should test selecting all firstName fields in the person collections'() {
        def agg = Aggregation.newAggregation(
                Person,
                project('clientNums').andExclude('_id')
        )
        when:
        AggregationResults<ArrayList<Integer>> aggregate = mongoTemplate.aggregate(agg, ArrayList)
        ArrayList<ArrayList<Integer>> results = aggregate.mappedResults

        then:
        results
    }

}
