/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.hibernate;

import org.farrukh.example.hibernate.datasource.DataSourceProvider;
import org.farrukh.example.hibernate.datasource.H2DataSourceProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Map;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractBaseTest {

    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";

    private static final String DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_DATA_SOURCE = "hibernate.connection.datasource";

    private final DataSourceProvider dataSourceProvider;
    private MetadataSources metadataSources;
    private SessionFactory sessionFactory;


    protected AbstractBaseTest(final DataSourceProvider dataSourceProvider) {
        this.dataSourceProvider = dataSourceProvider;
        //dataSourceProvider = dataSourceProvider();
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(dataSourceSettings())
                                                                                      .applySettings(hibernateSettings())
                                                                                      .build();
        try {
            metadataSources = new MetadataSources(serviceRegistry);
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
        Class<?>[] annotatedClasses = getAnnotatedClasses();
        for (Class<?> annotatedClass : annotatedClasses) {
            metadataSources.addAnnotatedClass(annotatedClass);
        }
        sessionFactory = metadataSources.buildMetadata()
                                        .buildSessionFactory();
    }

    protected AbstractBaseTest() {
        this(new H2DataSourceProvider());
    }

    protected abstract Class<?>[] getAnnotatedClasses();

    private Map hibernateSettings() {
        Properties properties = new Properties();
        properties.put(HIBERNATE_SHOW_SQL, true);
        properties.put(HIBERNATE_FORMAT_SQL, true);
        properties.put(HIBERNATE_HBM2DDL_AUTO, "create");
        return properties;
    }

    private Map dataSourceSettings() {
        Properties settings = new Properties();

        settings.put(DIALECT, dataSourceProvider.dialect());
        settings.put(HIBERNATE_DATA_SOURCE, dataSourceProvider.dataSource());
        return settings;
    }

    protected final SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @FunctionalInterface
    protected interface HibernateTransactionConsumer extends Consumer<Session> {
        default void beforeTransactionCompletion() {
        }

        default void afterTransactionCompletion() {
        }
    }

    @FunctionalInterface
    protected interface HibernateTransactionFunction<T> extends Function<Session, T> {
        default void beforeTransactionCompletion() {

        }

        default void afterTransactionCompletion() {

        }
    }

    protected void executeInTransaction(HibernateTransactionConsumer consumer) {
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            consumer.beforeTransactionCompletion();
            tx = session.beginTransaction();

            consumer.accept(session);
            tx.commit();
        } catch (Throwable e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            consumer.afterTransactionCompletion();
            if (session != null) {
                session.close();
            }
        }
    }


}
