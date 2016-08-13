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
import org.farrukh.example.hibernate.datasource.DataSourceProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.junit.Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

/**
 * Represents Unidirectional Many-To-Many association between.
 */
public class ManyToManyTest extends AbstractBaseTest {

    @Override
    protected Class<?>[] getAnnotatedClasses() {
        return new Class<?>[]{
                Employee.class,
                Skill.class
        };
    }

    @Override
    protected DataSourceProvider dataSourceProvider() {
        return null;
    }

    @Test
    public void testEmployeeHasManySkillsAndManySkillsReusedBetweenManyEmployee() throws Exception {
        try (Session session = getSessionFactory().openSession()) {
            Transaction tx = session.getTransaction();

            tx.begin();
            Employee jomi = new Employee("Jomi");
            Employee gani = new Employee("Gani");
            Employee sami = new Employee("Sami");
            Employee ali = new Employee("Ali");

            Skill java = new Skill("Java");
            Skill web = new Skill("Web");
            Skill sql = new Skill("SQL");
            Skill php = new Skill("PHP");

            jomi.setSkills(new HashSet<>(asList(java, sql, web)));
            gani.setSkills(new HashSet<>(asList(java, web)));
            sami.setSkills(new HashSet<>(asList(sql)));
            ali.setSkills(new HashSet<>(asList(php, sql)));

            session.save(jomi);
            session.save(gani);
            session.save(sami);
            session.save(ali);

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

        @NonNull
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

        @NonNull
        private final String skillName;
    }

}
