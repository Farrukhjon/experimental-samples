/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.hibernate.jpa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class EntityManagerTests {

    private EntityManager entityManager;

    @Before
    public void setUp() throws Exception {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");

        properties.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        properties.put("javax.persistence.jdbc.url", "jdbc:h2:mem:test");
        properties.put("javax.persistence.jdbc.user", "sa");
        properties.put("javax.persistence.jdbc.password", "");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-persistent-unit", properties);
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    public void testCRUD() {
        User user = new User();
        user.setLogin("vali@example.com");
        user.setPassword("password");

        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();

        User userFromDb = entityManager.find(User.class, 1L);

        Assert.assertEquals(1, userFromDb.getId());
    }
}
