/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.spring.data.access.jpa;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UserAppContextContainer.class)
public class UserCRUDTests {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private UserDao userDao;

    @Test
    public void shouldTest() {
        Assert.assertNotNull(entityManagerFactory);
        User user = new User();
        user.setLogin("ali@example.com");
        user.setPassword("password");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        User userFromDb = entityManager.find(User.class, 1L);
        entityManager.getTransaction().commit();

        Assert.assertEquals("password", userFromDb.getPassword());
        Assert.assertEquals("ali@example.com", userFromDb.getLogin());
        Assert.assertEquals(1L, userFromDb.getId());

    }

    @Test
    public void testUserDao() {
        User user = new User();
        user.setLogin("vali@example.com");
        user.setPassword("vali_word");
        long savedId = userDao.save(user);

        User savedUser = userDao.getUserById(savedId);

        Assert.assertEquals("vali_word", savedUser.getPassword());
        Assert.assertEquals("vali@example.com", savedUser.getLogin());
        Assert.assertEquals(1L, savedUser.getId());

    }

}
