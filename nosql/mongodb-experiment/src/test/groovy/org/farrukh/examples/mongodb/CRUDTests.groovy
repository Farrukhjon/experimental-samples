package org.farrukh.examples.mongodb

import com.mongodb.MongoClient
import com.mongodb.ServerAddress
import com.mongodb.client.MongoCollection
import org.bson.Document
import spock.lang.Specification

/**
 * Created by Farrukhjon on 6/2/15.
 */
class CRUDTests extends Specification {

    MongoClient mongoClient
    String dbName = 'testdb'

    def setup() {
        def port = 27017
        def host = 'localhost'
        mongoClient = new MongoClient(new ServerAddress(host, port))
    }

    def 'exercise count method for users collection'() {
        given: 'a data base'
        def database = mongoClient.getDatabase(dbName)

        and: 'instance of mongo collection interface for CRUD operations'
        MongoCollection<Document> mongoCollection = database.getCollection('users')

        and:
        Document document = new Document('key1', 'value1')

        when:
        mongoCollection.insertOne(document)

        then:
        mongoCollection
        mongoCollection.count()
    }
}
