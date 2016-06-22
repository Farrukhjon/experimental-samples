package org.farrukh.examples.java.jdbc.connection

import spock.lang.Specification

/**
 * Created by Farrukhjon on 25-Sep-15.
 */
class MySQLConnectionByDataSourceTest extends Specification {

    def 'exercise connection to mysql via DataSource'() {
        given:
        def sut = new MySQLConnectionByDataSource()

        when:
        def connection = sut.connectionUsingDataSource

        then:
        connection
    }
}
