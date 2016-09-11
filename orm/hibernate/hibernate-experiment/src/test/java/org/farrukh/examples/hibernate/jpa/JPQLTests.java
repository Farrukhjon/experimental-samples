/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.hibernate.jpa;

import org.farrukh.examples.hibernate.AbstractBaseTest;
import org.farrukh.examples.hibernate.datasource.MySQLDataSourceProvider;
import org.farrukh.examples.hibernate.model.Company;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Query;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Java Persistence query language (JPQL), Criteria API, and native SQL select queries are executed using the
 * getResultList() and getSingleResult() methods.
 * Update and delete operations (update and delete “queries”) are executed using the executeUpdate() method.
 */
public class JPQLTests extends AbstractBaseTest {

    @Override
    protected boolean nativeHibernateSessionFactory() {
        return false;
    }

    public JPQLTests() {
        super(new MySQLDataSourceProvider());
    }

    @Test
    public void shouldUpdateACompanyUsingNamedParameterBinding() throws Exception {
        executeUsingJPA(em -> {
            em.createQuery("update Company as c set c.name = :name where c.id = :id")
              .setParameter("name", "IBM")
              .setParameter("id", 1L)
              .executeUpdate();
        });
    }

    @Test
    public void shouldRetrieveACompanyUsingPositionalParameter() throws Exception {
        Company company = executeUsingJPA(em -> {
            return em.createQuery("SELECT c FROM Company c WHERE c.id = ?1 and c.name = ?2", Company.class)
                     .setParameter(1, 1L)
                     .setParameter(2, "IBM")
                     .getSingleResult();
        });
        assertEquals(1L, company.getId());
        assertEquals("IBM", company.getName());
    }

    @Test
    public void shouldGetAllCompaniesFromCompanyTableUsingQuery() throws Exception {

        List<Company> companies = executeUsingJPA(em -> {
            Query query = em.createQuery("select c from Company c");
            List<Company> resultList = query.getResultList();
            return resultList;
        });

        Company company = companies.get(0);
        assertNotNull(company.getId());
        assertNotNull(company.getName());
    }

    @Override
    protected Class<?>[] getAnnotatedClasses() {
        return new Class<?>[]{Company.class};
    }

}
