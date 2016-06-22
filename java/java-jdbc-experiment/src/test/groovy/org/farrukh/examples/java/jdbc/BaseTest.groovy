package org.farrukh.examples.java.jdbc

import groovy.sql.Sql
import org.farrukh.examples.java.jdbc.connection.MySQLConnectionByDataSource
import spock.lang.Specification

import java.sql.Connection


/**
 * Created by Farrukhjon on 25-Sep-15.
 */
class BaseTest extends Specification {

    def setup() {
        def sql = Sql.newInstance([url: 'jdbc:mysql://localhost:3306/test', user: 'root', password: 'mysql', driver: 'com.mysql.jdbc.Driver'])
        sql.execute('''
                   create table if not exists user (
                                                   name varchar(20),
                                                   password varchar(20) )
                   ''')
    }

    protected final Connection getConnection() {
        new MySQLConnectionByDataSource().connectionUsingDataSource
    }
}
