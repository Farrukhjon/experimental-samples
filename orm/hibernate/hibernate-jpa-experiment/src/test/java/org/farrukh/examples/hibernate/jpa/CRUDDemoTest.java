/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.hibernate.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

public class CRUDDemoTest {

    private Properties properties;

    @Before
    public void setUp() throws Exception {
        properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.connection.driver_class", "org.h2.Driver");
        properties.put("hibernate.connection.url", "jdbc:h2:mem:test");
        properties.put("hibernate.connection.username", "sa");
        properties.put("hibernate.connection.password", "");
    }

    @Test
    public void shouldConnectToTheH2DataBase() {
        SessionFactory sessionFactory = sessionFactory(properties);
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        User ali = new User();
        ali.setLogin("ali@example.com");

        session.save(ali);
        session.getTransaction().commit();

        session.beginTransaction();
        User user = session.get(User.class, 1L);

        Assert.assertEquals("ali@example.com", user.getLogin());
        session.getTransaction().commit();

        session.close();


    }

    private SessionFactory sessionFactory(final Properties properties) {
        return new Configuration()
                .addProperties(properties)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

}
