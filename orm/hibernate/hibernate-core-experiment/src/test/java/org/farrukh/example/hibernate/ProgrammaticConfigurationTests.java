/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.hibernate;

import org.hamcrest.core.Is;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.FlushModeType;
import java.util.Map;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProgrammaticConfigurationTests {

    private static final String USER_NAME = "root";
    private static final String PASSWORD = "sa";
    private static final String MYSQL5_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final boolean IS_LOGGED = true;

    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        Map settings = new Properties();
        settings.put("hibernate.dialect", MYSQL5_DIALECT);
        settings.put("hibernate.connection.driver_class", MYSQL_DRIVER);
        settings.put("hibernate.connection.url", MYSQL_URL);
        settings.put("hibernate.connection.username", USER_NAME);
        settings.put("hibernate.connection.password", PASSWORD);
        settings.put("hibernate.show_sql", IS_LOGGED);
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings)
                                                                                      .build();
        MetadataSources sources = new MetadataSources(serviceRegistry);
        Metadata metadata = sources.buildMetadata();
        sessionFactory = metadata.buildSessionFactory();
    }

    @Test
    public void testSession() throws Exception {
        boolean expectedSessionState = true;
        CacheMode expectedCacheMode = CacheMode.NORMAL;
        FlushModeType expectedFlushModeType = FlushModeType.AUTO;

        try (Session session = sessionFactory.openSession()) {
            boolean sessionState = session.isOpen();
            CacheMode cacheMode = session.getCacheMode();
            FlushModeType flushMode = session.getFlushMode();

            assertThat(sessionState, is(expectedSessionState));
            assertThat(cacheMode, is(expectedCacheMode));
            assertThat(flushMode, is(expectedFlushModeType));
        }

    }
}
