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

public class EntityManagerTests {

    private EntityManager entityManager;

    @Before
    public void setUp() throws Exception {
        EntityManagerFactoryProvider entityManagerFactoryProvider = new EntityManagerFactoryProvider();
        entityManager = entityManagerFactoryProvider.getEntityManagerFactory().createEntityManager();
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
