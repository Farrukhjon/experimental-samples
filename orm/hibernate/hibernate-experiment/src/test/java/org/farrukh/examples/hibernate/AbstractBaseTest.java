/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.hibernate;

import org.farrukh.examples.hibernate.datasource.DataSourceProvider;
import org.farrukh.examples.hibernate.datasource.H2DataSourceProvider;
import org.farrukh.examples.hibernate.jpa.EntityManagerFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractBaseTest {

    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";

    private static final String DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_CONNECTION_DATASOURCE = "hibernate.connection.datasource";
    private static final String HIBERNATE_GENERATE_STATISTICS = "hibernate.generate_statistics";

    private final DataSourceProvider dataSourceProvider;
    private MetadataSources metadataSources;

    private SessionFactory sessionFactory;
    private EntityManagerFactory emFactory;


    protected AbstractBaseTest(final DataSourceProvider dataSourceProvider) {
        Class<?>[] annotatedClasses = getAnnotatedClasses();
        this.dataSourceProvider = dataSourceProvider;
        if (nativeHibernateSessionFactory()) {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties())
                                                                                          .build();
            try {
                metadataSources = new MetadataSources(serviceRegistry);
            } catch (Exception e) {
                StandardServiceRegistryBuilder.destroy(serviceRegistry);
            }
            for (Class<?> annotatedClass : annotatedClasses) {
                metadataSources.addAnnotatedClass(annotatedClass);
            }
            sessionFactory = metadataSources.buildMetadata()
                                            .buildSessionFactory();

        } else {
            List<String> managedClassNames = Stream.of(annotatedClasses)
                                                   .map(Class::getName)
                                                   .collect(Collectors.toList());
            EntityManagerFactoryProvider emfp = new EntityManagerFactoryProvider(properties(), managedClassNames);
            emFactory = emfp.buildEntityManagerFactory();
        }
    }

    protected boolean nativeHibernateSessionFactory() {
        return true;
    }

    protected AbstractBaseTest() {
        this(new H2DataSourceProvider());
    }

    protected abstract Class<?>[] getAnnotatedClasses();

    private Properties properties() {
        Properties properties = new Properties();
        properties.put(HIBERNATE_SHOW_SQL, true);
        properties.put(HIBERNATE_FORMAT_SQL, true);
        properties.put(HIBERNATE_HBM2DDL_AUTO, "create");
        properties.put(HIBERNATE_GENERATE_STATISTICS, Boolean.TRUE.toString());
        properties.put(DIALECT, dataSourceProvider.dialect());
        properties.put(HIBERNATE_CONNECTION_DATASOURCE, dataSourceProvider.dataSource());
        return properties;
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

    protected final void executeUsingNativeHibernate(HibernateTransactionConsumer consumer) {
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

    protected final void executeUsingJPA(Consumer<EntityManager> consumer) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            consumer.accept(em);
            tx.commit();
        } catch (Throwable throwable) {
            if (tx != null && tx.isActive())
                tx.rollback();
            throw throwable;
        } finally {
            if (em != null)
                em.close();
        }
    }

    protected final <T> T executeUsingJPA(Function<EntityManager, T> function) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = emFactory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            T result = function.apply(em);
            tx.commit();
            return result;
        } catch (Throwable throwable) {
            if (tx != null && tx.isActive())
                tx.rollback();
            throw throwable;
        } finally {
            if (em != null)
                em.close();
        }
    }

}
