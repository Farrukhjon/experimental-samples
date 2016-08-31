/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.jooq.config;

import org.junit.Test;

import static org.farrukh.examples.jooq.tables.Employees.EMPLOYEES;

public class BatchTests extends AbstractBaseTest {

    @Test
    public void test1() throws Exception {
        create().batch(create().insertInto(EMPLOYEES, EMPLOYEES.FIRSTNAME).values("Jamil")).execute();
    }
}
