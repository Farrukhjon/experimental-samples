package org.farrukh.examples.mongodb

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.ServerAddress
import spock.lang.Specification

/**
 * Created by Farrukhjon on 6/2/15.
 */
class MongoClientTests extends Specification {

    private static final int PORT = 27017
    private static final String HOST_NAME = 'localhost'
    private static final String HOST_ADDRESS = '127.0.0.1'

    def 'exercise mongo client connection with default host and port'() {
        when:
        def mongoClient = new MongoClient()

        then:
        mongoClient
        mongoClient.getAddress().host == HOST_ADDRESS
        mongoClient.getAddress().port == PORT
    }

    def 'exercise creating mongo client connection using URL description'() {
        given:
        String url = 'mongodb://localhost:27017/test'
        def mongoClientURI = new MongoClientURI(url)

        when:
        def mongoClient = new MongoClient(mongoClientURI)

        then:
        mongoClient
    }

    def 'exercise mongo client connection with server address'() {
        when:
        def serverAddress = new ServerAddress(HOST_NAME, PORT)
        def mongoClient = new MongoClient(serverAddress)

        then:
        mongoClient
    }
}
