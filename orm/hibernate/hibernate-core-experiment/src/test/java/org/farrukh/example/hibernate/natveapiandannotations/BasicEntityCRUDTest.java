/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.hibernate.natveapiandannotations;

import org.farrukh.example.hibernate.model.Customer;
import org.farrukh.example.hibernate.model.Order;
import org.farrukh.example.hibernate.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class BasicEntityCRUDTest {

    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
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

    @Test
    public void successCreationOfSessionFactory() throws Exception {
        assertNotNull(sessionFactory);
    }

    @Test
    public void testSomeLibraryMethod() {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Customer customer = new Customer();
        customer.setName("Ali");
        session.save(customer);

        Product printer = new Product();
        printer.setName("3D Printer");
        session.save(printer);

        Order order = new Order();
        order.setCustomer(customer);
        order.setProduct(printer);
        Serializable saved = session.save(order);

        session.getTransaction().commit();

        assertNotNull(saved);
        session.close();
        sessionFactory.close();

    }
}
