/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.groovy.sql

import groovy.sql.Sql
import org.hsqldb.jdbc.JDBCDataSource


class Connection {

    private static Sql sql

    static Sql connect() {
        def dataSource = new JDBCDataSource(database: 'jdbc:hsqldb:mem:testdb', user: 'sa', password: '')
        sql = new Sql(dataSource)
        sql
    }

    def close() {
        sql.close()
    }

}
