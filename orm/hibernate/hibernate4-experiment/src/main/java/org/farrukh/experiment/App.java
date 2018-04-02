package org.farrukh.experiment;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.metamodel.MetadataSources;

import java.util.Properties;

/**
 * Hello world!
 */
public class App {

    public static SessionFactory createSessionFactory(final Properties properties) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(properties)
                .build();
        try {
            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            return metadataSources.buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder
                    .destroy(serviceRegistry);
        }
    }
}
