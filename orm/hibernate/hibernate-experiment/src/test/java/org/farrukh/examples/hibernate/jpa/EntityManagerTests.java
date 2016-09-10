/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.hibernate.jpa;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class EntityManagerTests {

    private EntityManager entityManager;
    private EntityManager xmlLessEntityManager;

    public EntityManagerTests() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-persistent-unit", createProperties());
        entityManager = entityManagerFactory.createEntityManager();

        EntityManagerFactoryProvider entityManagerFactoryProvider = new EntityManagerFactoryProvider();
        xmlLessEntityManager = entityManagerFactoryProvider.getEntityManagerFactory().createEntityManager();
    }

    private Map<String, String> createProperties() {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");

        properties.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        properties.put("javax.persistence.jdbc.url", "jdbc:h2:mem:test");
        properties.put("javax.persistence.jdbc.user", "sa");
        properties.put("javax.persistence.jdbc.password", "");
        return properties;
    }

    @Test
    public void ensureEntityManager() {
        assertNotNull(entityManager);
        assertNotNull(xmlLessEntityManager);
    }

}
