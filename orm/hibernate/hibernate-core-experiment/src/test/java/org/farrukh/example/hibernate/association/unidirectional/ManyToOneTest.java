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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents from a child entity to a parent entity.
 * This association bases on a database JOIN semantics.
 * This kind of association is most common case.
 * Each entities (child and parent) has its own lifecycle.
 * Hibernate will set (generate) foreign key association between a parent (from parent side) and a child.
 */
public class ManyToOneTest extends AbstractBaseTest {

    private SessionFactory sessionFactory;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        sessionFactory = getMetadataSources()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Phone.class)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Test
    public void test() throws Exception {
        Transaction tx;
        try (Session session = sessionFactory.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            Person vali = new Person();
            vali.setName("Vali");
            Phone mobile = new Phone();
            mobile.setNumber("(+992)928885846");

            Phone home = new Phone();
            home.setNumber("(+992)834220001");

            mobile.setPerson(vali);
            home.setPerson(vali);

            session.save(mobile);
            session.save(home);
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
    }

    @Entity
    @Table(name = "phones")
    @Getter
    @Setter
    private static class Phone {
        @Id
        @GeneratedValue
        private long id;

        @Column(nullable = false)
        private String number;

        @ManyToOne
        @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "FK_PERSON_ID"))
        @Cascade(CascadeType.SAVE_UPDATE)
        private Person person;

    }


}
