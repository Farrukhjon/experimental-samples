package org.farrukh.examples.java.jdbc.statement

import org.farrukh.examples.java.jdbc.BaseTest
import org.farrukh.examples.java.jdbc.connection.MySQLConnectionByDataSource

/**
 * Created by Farrukhjon on 25-Sep-15.
 */
class PreparedStatementTests extends BaseTest {

    def 'exercise creating prepare statement'() {
        given:
        def connection = new MySQLConnectionByDataSource().connectionUsingDataSource
        def sql = "select * from user"

        when:
        def prepareStatement = connection.prepareStatement(sql)

        then:
        prepareStatement
    }

    def 'exercise inserting values'() {
        given:
        def connection = new MySQLConnectionByDataSource().connectionUsingDataSource

        and:
        def prepareStatement = connection.prepareStatement("insert into user values (?, ?)")

        when:
        prepareStatement.setString(1, 'Ali')
        prepareStatement.setString(2, 'password1')
        def result = prepareStatement.executeUpdate()

        then:
        result
    }
}
