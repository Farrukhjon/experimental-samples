package org.farrukh.examples.groovy.sql

import groovy.sql.Sql

class ConnectionWithDatabaseDemo {

    static void main(String[] args) {

        def url = 'jdbc:hsqldb:mem:testdb'
        def username = 'sa'
        def password = ''
        def driver = 'org.hsqldb.jdbcDriver'

        def sql = Sql.newInstance(url, username, password, driver)

        assert sql

        sql.close()

    }


}
