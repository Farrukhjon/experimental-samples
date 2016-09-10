/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.hibernate;

import org.farrukh.examples.hibernate.model.Customer;
import org.farrukh.examples.hibernate.model.Order;
import org.farrukh.examples.hibernate.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class BasicEntityCRUDTest extends AbstractBaseTest {

    private SessionFactory sessionFactory;

    public BasicEntityCRUDTest() {
        sessionFactory = getSessionFactory();
    }

    @Test
    public void successCreationOfSessionFactory() throws Exception {
        assertNotNull(sessionFactory);
    }

    @Test
    public void shouldSaveOrder() {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Customer customer = new Customer();
        customer.setName("Ali");

        Product printer = new Product();
        printer.setName("3D Printer");

        Order order = new Order();
        order.setCustomer(customer);
        order.setProduct(printer);
        Serializable saved = session.save(order);

        session.getTransaction().commit();

        assertNotNull(saved);
        session.close();
        sessionFactory.close();

    }

    @Test
    @Ignore
    public void shouldReadOrder() throws Exception {
        Session session = sessionFactory.openSession();
        Order order = session.load(Order.class, 3);
        int id = order.getId();
        int customerId = order.getCustomer().getId();
        int productId = order.getProduct().getId();
    }

    @Override
    protected Class<?>[] getAnnotatedClasses() {
        return new Class<?>[]{
                Order.class,
                Customer.class,
                Product.class
        };
    }

}
