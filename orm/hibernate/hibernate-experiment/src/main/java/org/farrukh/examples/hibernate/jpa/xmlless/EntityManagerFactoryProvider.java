/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.hibernate.jpa.xmlless;

import org.farrukh.examples.hibernate.model.User;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Interceptor;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;

import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceUnitInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class EntityManagerFactoryProvider {

    private final EntityManagerFactory entityManagerFactory;
    private final List<String> managedClassNames = Arrays.asList(User.class.getName());

    public EntityManagerFactoryProvider() {

        String persistenceUnitName = "test-jpa";
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");

        properties.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        properties.put("javax.persistence.jdbc.url", "jdbc:h2:mem:test");
        properties.put("javax.persistence.jdbc.user", "sa");
        properties.put("javax.persistence.jdbc.password", "");
        PersistenceUnitInfo persistenceUnitInfo = new PersistenceUnitInfoImpl(persistenceUnitName, properties, managedClassNames);
        PersistenceUnitInfoDescriptor persistenceUnitInfoDescriptor = new PersistenceUnitInfoDescriptor(persistenceUnitInfo);
        Map<String, Interceptor> integrationSettings = new HashMap<>();
        integrationSettings.put(AvailableSettings.INTERCEPTOR, EmptyInterceptor.INSTANCE);

        EntityManagerFactoryBuilderImpl factoryBuilder = new EntityManagerFactoryBuilderImpl(persistenceUnitInfoDescriptor, integrationSettings);

        entityManagerFactory = factoryBuilder.build();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}
