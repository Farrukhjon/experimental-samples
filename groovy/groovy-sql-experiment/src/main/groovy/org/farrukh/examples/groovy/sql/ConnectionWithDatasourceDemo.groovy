package org.farrukh.examples.groovy.sql

import groovy.sql.Sql
import org.hsqldb.jdbc.JDBCDataSource

class ConnectionWithDatasourceDemo {

    static void main(String[] args) {

        def url = 'jdbc:hsqldb:mem:testdb'
        def username = 'sa'
        def password = ''
        def dataSource = new JDBCDataSource(database: url, user: username, password: password)
        def sql = new Sql(dataSource)

        assert sql

        sql.close()

    }


}
