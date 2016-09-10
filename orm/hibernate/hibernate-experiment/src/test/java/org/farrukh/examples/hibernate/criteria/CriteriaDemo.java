/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.hibernate.criteria;

import org.farrukh.examples.hibernate.AbstractBaseTest;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;

public class CriteriaDemo extends AbstractBaseTest {

    @Override
    protected Class<?>[] getAnnotatedClasses() {
        return new Class<?>[0];
    }

    @Test
    public void test() throws Exception {
        executeInTransaction(session -> {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        });

    }
}
