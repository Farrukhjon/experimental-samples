/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.jooq;

import org.farrukh.examples.jooq.datasource.DataSourceProvider;
import org.farrukh.examples.jooq.datasource.MySQLDataSourceProvider;
import org.farrukh.examples.jooq.tables.Employees;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

public class Main {

    public static void main(String[] args) {
        DataSourceProvider dataSourceProvider = new MySQLDataSourceProvider();
        DSLContext create = DSL.using(dataSourceProvider.dataSource(), dataSourceProvider.dialect());
        create.selectFrom(Employees.EMPLOYEES)
              .fetch()
              .forEach(System.out::println);
    }

}
