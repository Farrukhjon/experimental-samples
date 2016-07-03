/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.groovy.sql

import groovy.sql.Sql
import org.hsqldb.jdbc.JDBCDataSource

class CreatingTableDemo {

    static void main(String[] args) {

        def url = 'jdbc:hsqldb:mem:testdb'
        def username = 'sa'
        def password = ''
        def sql = new Sql(new JDBCDataSource(database: url, user: username, password: password))

        sql.execute '''
                        CREATE TABLE Author (
                            id          INTEGER GENERATED BY DEFAULT AS IDENTITY,
                            firstname   VARCHAR(64),
                            lastname    VARCHAR(64)
                          );
                        '''
    }

}