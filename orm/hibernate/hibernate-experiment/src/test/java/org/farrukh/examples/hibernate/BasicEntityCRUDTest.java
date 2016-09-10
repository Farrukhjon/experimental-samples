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
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class BasicEntityCRUDTest extends AbstractBaseTest {

    @Test
    public void shouldSaveOrder() {
        executeInTransaction(session -> {
            Customer customer = new Customer();
            customer.setName("Ali");

            Product printer = new Product();
            printer.setName("3D Printer");

            Order order = new Order();
            order.setCustomer(customer);
            order.setProduct(printer);
            Serializable saved = session.save(order);
            assertNotNull(saved);
        });
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
