/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */
package org.farrukh.examples.spring.data.jpa;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.mysema.query.types.expr.BooleanExpression;

/**
 * Integration tests for {@link CustomerRepository}.
 *
 * @author Oliver Gierke
 * @since Step 2
 */
public class CustomerRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    CustomerRepository repository;

    /**
     * @since Step 2.1
     */
    @Test
    public void findsCustomerById() {

        Customer customer = repository.findOne(1L);

        assertThat(customer, is(notNullValue()));
        assertThat(customer.getFirstname(), is("Dave"));
        assertThat(customer.getLastname(), is("Matthews"));
    }

    /**
     * @since Step 2.2
     */
    @Test
    public void savesNewCustomer() {

        Customer stefan = new Customer("Stefan", "Lassard");
        Customer result = repository.save(stefan);

        assertThat(result, is(notNullValue()));
        assertThat(result.getId(), is(notNullValue()));
        assertThat(result.getFirstname(), is("Stefan"));
        assertThat(result.getLastname(), is("Lassard"));
    }

    /**
     * @since Step 2.3
     */
    @Test
    public void savesExistingCustomer() {

        Customer dave = repository.findOne(1L);
        dave.setEmailAddress(new EmailAddress("davematthews@dmband.com"));
        repository.save(dave);

        Customer result = repository.findOne(1L);

        assertThat(result, is(notNullValue()));
        assertThat(result.getId(), is(notNullValue()));
        assertThat(result.getFirstname(), is("Dave"));
        assertThat(result.getEmailAddress(), is(new EmailAddress("davematthews@dmband.com")));
    }

    /**
     * @since Step 2.4
     */
    @Test
    public void findsCustomersByEmailAddress() {

        Customer result = repository.findByEmailAddress(new EmailAddress("dave@dmband.com"));

        assertThat(result, is(notNullValue()));
        assertThat(result.getFirstname(), is("Dave"));
        assertThat(result.getLastname(), is("Matthews"));
    }

    /**
     * @since Step 3.1
     */
    @Test
    public void findsAllCustomers() {

        List<Customer> customers = repository.findAll();
        assertThat(customers, hasSize(4));
    }

    /**
     * @since Step 3.2
     */
    @Test
    public void deletesCustomer() {

        repository.delete(1L);
        assertThat(repository.findOne(1L), is(nullValue()));
    }

    /**
     * @since Step 4.1
     */
    @Test
    public void accessesCustomersPageByPage() {

        Page<Customer> result = repository.findAll(new PageRequest(1, 1));

        assertThat(result, is(notNullValue()));
        assertThat(result.isFirst(), is(false));
        assertThat(result.isLast(), is(false));
        assertThat(result.getNumberOfElements(), is(1));
    }

    /**
     * @since Step 8
     */
    @Test
    public void executesQuerydslPredicate() {

        Customer dave = repository.findByEmailAddress(new EmailAddress("dave@dmband.com"));
        Customer carter = repository.findByEmailAddress(new EmailAddress("carter@dmband.com"));

        de.olivergierke.deepdive.QCustomer customer = de.olivergierke.deepdive.QCustomer.customer;

        BooleanExpression firstnameStartsWithDa = customer.firstname.startsWith("Da");
        BooleanExpression lastnameContainsEau = customer.lastname.contains("eau");

        Iterable<Customer> result = repository.findAll(firstnameStartsWithDa.or(lastnameContainsEau));

        assertThat(result, is(Matchers.iterableWithSize(3)));
        assertThat(result, Matchers.hasItems(dave, carter));
    }
}
