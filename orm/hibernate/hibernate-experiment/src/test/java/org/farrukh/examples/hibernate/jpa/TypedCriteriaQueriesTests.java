/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.hibernate.jpa;

import org.farrukh.examples.hibernate.AbstractBaseTest;
import org.farrukh.examples.hibernate.model.User;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * From the documentation:
 * Criteria queries offer a type-safe alternative to HQL, JPQL and native SQL queries.
 * Hibernate offers an older, legacy org.hibernate.Criteria API which should be considered deprecated.
 * No feature development will target those APIs.
 * Eventually, Hibernate-specific criteria features will be ported as extensions to the JPA javax.persistence.criteria.CriteriaQuery.
 * For details on the org.hibernate.Criteria API, see Legacy Hibernate Criteria Queries.
 */
public class TypedCriteriaQueriesTests extends AbstractBaseTest {

    @Test
    public void test() throws Exception {
        executeUsingJPA(entityManager -> {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            Root<User> userRoot = criteria.from(User.class);
            /*criteria.select(userRoot).where(builder.equal(userRoot.get()));*/
        });

    }

    @Override
    protected Class<?>[] getAnnotatedClasses() {
        return new Class<?>[0];
    }
}
