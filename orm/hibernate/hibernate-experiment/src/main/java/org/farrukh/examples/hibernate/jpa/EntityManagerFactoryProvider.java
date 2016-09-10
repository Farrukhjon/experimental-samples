/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.hibernate.jpa;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Interceptor;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceUnitInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class EntityManagerFactoryProvider {

    private EntityManagerFactoryBuilder emfBuilder;

    public EntityManagerFactoryProvider() {
        this(null, null);
    }

    public EntityManagerFactoryProvider(final Properties properties, final List<String> managedClassNames) {
        String persistenceUnitName = getClass().getSimpleName();
        PersistenceUnitInfo persistenceUnitInfo = new PersistenceUnitInfoImpl(persistenceUnitName, properties, managedClassNames);
        PersistenceUnitInfoDescriptor persistenceUnitInfoDescriptor = new PersistenceUnitInfoDescriptor(persistenceUnitInfo);
        Map<String, Interceptor> integrationSettings = new HashMap<>();
        integrationSettings.put(AvailableSettings.INTERCEPTOR, EmptyInterceptor.INSTANCE);

        emfBuilder = new EntityManagerFactoryBuilderImpl(persistenceUnitInfoDescriptor, integrationSettings);
    }

    public EntityManagerFactory buildEntityManagerFactory() {
        return emfBuilder.build();
    }

}
