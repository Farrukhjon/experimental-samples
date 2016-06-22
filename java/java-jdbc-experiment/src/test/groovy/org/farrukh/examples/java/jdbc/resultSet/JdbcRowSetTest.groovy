package org.farrukh.examples.java.jdbc.resultSet

import com.sun.rowset.JdbcRowSetImpl
import org.farrukh.examples.java.jdbc.BaseTest

import javax.sql.rowset.RowSetProvider

import static java.sql.ResultSet.CONCUR_UPDATABLE
import static java.sql.ResultSet.TYPE_SCROLL_SENSITIVE

/**
 * Created by Farrukhjon on 25-Sep-15.
 */
class JdbcRowSetTest extends BaseTest {

    def 'exercise creating JdbcRowSet object via ResultSet'() {
        given:
        def sql = "select * from user"
        // If you have run the method createStatement without any arguments, resultSet would not be scrollable or updatable, and neither would jdbcRs.
        def statement = getConnection().createStatement(TYPE_SCROLL_SENSITIVE, CONCUR_UPDATABLE)
        def resultSet = statement.executeQuery(sql)

        when:
        def jdbcRowSet = new JdbcRowSetImpl(resultSet)

        then:
        jdbcRowSet
    }

    def 'exercise creating JdbcRowSet object via Connection'() {
        given:
        def jdbcRowSet = new JdbcRowSetImpl(getConnection())

        and:
        String sql = "select * from user"

        when:
        jdbcRowSet.setCommand(sql)
        jdbcRowSet.execute()

        then:
        jdbcRowSet

    }

    def 'exercise creating JdbcRowSet object via default constructor'() {

        given:
        def jdbcRowSet = new JdbcRowSetImpl()

        and:
        def sql = "select * from user"

        when:
        jdbcRowSet.setCommand(sql)
        jdbcRowSet.setUrl('jdbc:mysql://localhost:3306/test')
        jdbcRowSet.setUsername('root')
        jdbcRowSet.setPassword('mysql')
        jdbcRowSet.execute()

        then:
        jdbcRowSet
    }

    def 'exercise creating JdbcRowSet object via RowSetFactory'() {

        when:
        def rowSetFactory = RowSetProvider.newFactory()

        and:
        JdbcRowSetImpl jdbcRowSet = rowSetFactory.createJdbcRowSet()

        then:
        jdbcRowSet
    }
}
