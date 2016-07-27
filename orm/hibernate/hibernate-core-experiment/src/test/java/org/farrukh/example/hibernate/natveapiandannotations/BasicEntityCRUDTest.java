/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.hibernate.natveapiandannotations;

import org.farrukh.example.hibernate.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

public class BasicEntityCRUDTest {

    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        String url = "hibernate.cfg.xml";
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure(url)
                                                                                      .build();
        try {
            MetadataSources sources = new MetadataSources(serviceRegistry);
            sources.addAnnotatedClass(Order.class);
            sessionFactory = sources.buildMetadata()
                                                                 .buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

    @Test
    public void testSomeLibraryMethod() {
        Assert.assertNotNull(sessionFactory);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Serializable saved = session.save(new Order());

        session.getTransaction().commit();
        Assert.assertNotNull(saved);
        session.close();
        sessionFactory.close();

    }
}
