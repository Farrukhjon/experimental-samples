package org.farrukh.examples.mongodb

import org.farrukh.examples.mongodb.connection.MongoConnectionUtil
import spock.lang.Specification

/**
 * Created by Farrukhjon on 6/1/15.
 */
class MongoConnectionTests extends Specification {

    def connectionFactory = MongoConnectionUtil.instance.createDatastore()

    def 'exercise connection to the db'() {
        expect:
        connectionFactory
    }
}
