package org.farrukh.examples.mongodb

import com.mongodb.Block
import com.mongodb.MongoClient
import org.bson.Document
import spock.lang.Specification

/**
 * Created by Farrukhjon on 23-Sep-15.
 */
class ExerciseRestaurantsCollection extends Specification {

    private static final String HOST_NAME = 'mongo'
    private static final String DB_NAME = 'db'
    private static final int PORT = 27017;
    private static final String COLLECTION_NAME = 'restaurants'


    def 'find and query data'() {
        given:
        def collection = new MongoClient(HOST_NAME, PORT).getDatabase(DB_NAME).getCollection(COLLECTION_NAME)

        when:
        def findIterable = collection.find()
        findIterable.forEach(new Block<Document>() {
            @Override
            void apply(Document document) {
                println document
            }
        })

        then:
        true
    }
}
