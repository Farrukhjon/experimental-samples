/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;

import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractBaseTest {

    private MetadataSources metadataSources;
    private SessionFactory sessionFactory;

    protected abstract Class<?>[] getAnnotatedClasses();

    @Before
    public void setUp() throws Exception {
        String url = "hibernate.cfg.xml";
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure(url)
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

    protected SessionFactory getSessionFactory() {
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
