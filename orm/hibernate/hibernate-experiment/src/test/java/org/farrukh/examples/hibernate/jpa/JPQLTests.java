/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.hibernate.jpa;

import lombok.Getter;
import lombok.Setter;
import org.farrukh.examples.hibernate.AbstractBaseTest;
import org.farrukh.examples.hibernate.datasource.MySQLDataSourceProvider;
import org.junit.Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import java.util.List;

public class JPQLTests extends AbstractBaseTest {

    @Override
    protected boolean nativeHibernateSessionFactory() {
        return false;
    }

    public JPQLTests() {
        super(new MySQLDataSourceProvider());
    }

    @Test
    public void test() throws Exception {
        executeUsingJPA(em -> {
            Query query = em.createQuery("select c from company c");
            List resultList = query.getResultList();
        });

    }

    @Override
    protected Class<?>[] getAnnotatedClasses() {
        return new Class<?>[]{Company.class};
    }

    @Entity
    @Table(name = "company")
    @Getter
    @Setter
    public static class Company {
        @Id
        @GeneratedValue
        private long id;
        private String name;
    }


}
