package org.farrukh.examples.spring.data.mongodb.repository;

import org.farrukh.examples.spring.data.mongodb.domain.Person;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class PersonRepositoryImpl implements PersonRepositoryAdvanced {

    private final MongoOperations mongoTemplate;

    public PersonRepositoryImpl(final MongoOperations mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Person update(final Person person) {
        return mongoTemplate.findAndModify(query(where("lastName").is(person.getLastName())), Update.update("age", person.getAge()), Person.class);
    }

    @Override
    public List<Person> find(final int clientNumber) {
        Aggregation clientNums = Aggregation.newAggregation(
                project("clientNums")
        );
        AggregationResults<Integer> results = mongoTemplate.aggregate(clientNums, "clientNums", Integer.class);
        List<Integer> mappedResults = results.getMappedResults();
        //mongoTemplate.find(query(where("clientNums").nin(clientNumbers)), Person.class);
        return null;
    }

}
