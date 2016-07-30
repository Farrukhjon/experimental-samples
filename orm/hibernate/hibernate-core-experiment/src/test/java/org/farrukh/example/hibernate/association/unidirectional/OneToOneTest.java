/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.hibernate.association.unidirectional;

import lombok.Getter;
import lombok.Setter;
import org.farrukh.example.hibernate.AbstractBaseTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents Unidirectional One-To-One association.
 * In this kind of association relationship achieved by a database FOREIGN KEY SEMANTICS.
 */
public class OneToOneTest extends AbstractBaseTest {

    private SessionFactory sessionFactory = null;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        sessionFactory = getMetadataSources()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Address.class)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Test
    public void testOneToOneUnidirectionalAssociationBetweenCustomerAndOrder() {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.getTransaction();

            tx.begin();
            Address khujand = new Address();
            khujand.setCity("Khujand");
            khujand.setStreet("19 micro-district, 2/58");
            Person ali = new Person();
            ali.setName("Ali");
            ali.setAddress(khujand);
            session.save(ali);
            tx.commit();
        }

    }

    @Entity
    @Table(name = "persons")
    @Getter
    @Setter
    private static class Person {
        @Id
        @GeneratedValue
        private long id;

        private String name;

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "FK_ADDRESS_ID"), nullable = false)
        @Cascade(CascadeType.SAVE_UPDATE)
        private Address address;

    }

    @Entity
    @Table(name = "address")
    @Getter
    @Setter
    private static class Address {
        @Id
        @GeneratedValue
        private long id;

        private String city;
        private String street;

    }

}
