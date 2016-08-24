/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.hibernate;

import org.farrukh.example.hibernate.model.Customer;
import org.farrukh.example.hibernate.model.Order;
import org.farrukh.example.hibernate.model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryProvider {

    private SessionFactory sessionFactory = null;

    public SessionFactoryProvider() {
        String url = "hibernate.cfg.xml";
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure(url)
                                                                                      .build();
        try {
            MetadataSources sources = new MetadataSources(serviceRegistry);
            sources.addAnnotatedClass(Order.class)
                   .addAnnotatedClass(Customer.class)
                   .addAnnotatedClass(Product.class);
            sessionFactory = sources.buildMetadata()
                                    .buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
