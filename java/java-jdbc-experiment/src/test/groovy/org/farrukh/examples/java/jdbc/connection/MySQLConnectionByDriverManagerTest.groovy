package org.farrukh.examples.java.jdbc.connection

import spock.lang.Specification

/**
 * Created by Farrukhjon on 25-Sep-15.
 */
class MySQLConnectionByDriverManagerTest extends Specification {

    def 'exercise connection to mysql via DriverManager'() {
        given:
        def sut = new MySQLConnectionByDriverManager()

        when:
        def connection = sut.connectionUsingDriverManager

        then:
        connection
    }
}
