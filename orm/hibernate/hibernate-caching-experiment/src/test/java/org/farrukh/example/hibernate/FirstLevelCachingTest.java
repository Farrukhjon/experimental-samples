/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.hibernate;

import org.farrukh.example.hibernate.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FirstLevelCachingTest {

    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        sessionFactory = new SessionFactoryProvider().getSessionFactory();
    }

    @Test
    public void shouldDemonstrateUsingFirstLevelCache() throws Exception {
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();
        Order firstLoadedOrder = session.load(Order.class, 3);
        Order secondLoadedOrder = session.load(Order.class, 3);
        session.getTransaction().commit();
        session.close();
    }

    @After
    public void tearDown() throws Exception {
        sessionFactory.close();
    }
}
