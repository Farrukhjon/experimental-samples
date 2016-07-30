/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.hibernate.association.unidirectional;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents Unidirectional Many-To-Many association between.
 */
public class ManyToManyTest extends AbstractBaseTest {

    private SessionFactory sessionFactory;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        sessionFactory = getMetadataSources()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Skill.class)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Test
    public void testEmployeeHasManySkillsAndManySkillsReusedBetweenManyEmployee() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.getTransaction();

            tx.begin();
            Employee jomi = new Employee("Jomi");
            Employee gani = new Employee("Gani");

            Skill java = new Skill("Java");
            Skill web = new Skill("Web");

            jomi.setSkills(new HashSet<>(Arrays.asList(java, new Skill("SQL"), web)));
            gani.setSkills(new HashSet<>(Arrays.asList(java, web)));

            session.save(jomi);
            session.save(gani);

            tx.commit();
        }

    }

    @Entity
    @Table(name = "employee")
    @Getter
    @Setter
    @RequiredArgsConstructor
    private static class Employee {

        @Id
        @GeneratedValue
        private long id;

        @NotNull
        private final String name;

        @ManyToMany
        @Cascade(CascadeType.ALL)
        private Set<Skill> skills;
    }

    @Entity
    @Table(name = "skills")
    @Getter
    @Setter
    @RequiredArgsConstructor
    private static class Skill {

        @Id
        @GeneratedValue
        private long id;

        @NotNull
        private final String skillName;
    }

}
