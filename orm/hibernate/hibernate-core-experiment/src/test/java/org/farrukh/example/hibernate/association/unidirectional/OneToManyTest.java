/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.hibernate.association.unidirectional;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.farrukh.example.hibernate.AbstractBaseTest;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.junit.Test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Unidirectional One-To-Many association between a PARENT and ONE OR MORE CHILD.
 * Represents relationship between a parent with one or many child entities.
 * For linkage will be generated the parent_child relational table with parent to children id references.
 */
public class OneToManyTest extends AbstractBaseTest {

    @Override
    protected Class<?>[] getAnnotatedClasses() {
        return new Class<?>[]{
                Person.class,
                Phone.class
        };
    }

    @Test
    public void test() throws Exception {
        Transaction tx;
        try (Session session = getSessionFactory().openSession()) {
            tx = session.getTransaction();
            tx.begin();
            Person sami = new Person("Sami");
            Phone mobile = new Phone("(+992)928885847");
            Phone home = new Phone("(+992)834220002");

            sami.setPhones(new HashSet<>(Arrays.asList(mobile, home)));

            session.save(sami);
            tx.commit();
        }
    }

    /**
     * Parent class for Phone.
     */
    @Entity
    @Table(name = "persons")
    @Getter
    @Setter
    @RequiredArgsConstructor
    private static class Person {
        @Id
        @GeneratedValue
        private long id;

        @NonNull
        @Column(nullable = false)
        private final String name;

        @OneToMany(orphanRemoval = true)
        @Cascade(CascadeType.SAVE_UPDATE)
        private Set<Phone> phones;
    }

    /**
     * Child class for Person.
     */
    @Entity
    @Table(name = "phones")
    @Getter
    @Setter
    @RequiredArgsConstructor
    private static class Phone {
        @Id
        @GeneratedValue
        private long id;

        @NonNull
        @Column(nullable = false)
        private final String number;

    }


}
