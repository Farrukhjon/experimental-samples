package org.farrukh.experiments.hibernate3;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        Configuration configuration = new Configuration();
        sessionFactory = configuration
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
    }

    @Test
    public void shouldPersistRandomEmployees() throws Exception {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < 7; i++) {
            Person person = new Person();
            person.setId((long)i);
            String randomFirstName = RandomStringUtils.random(7);
            person.setFirstName(randomFirstName);
            String randomLastName = RandomStringUtils.random(7);
            person.setLastName(randomLastName);
            Double randomSalary = RandomUtils.nextDouble(100000d, 200000d);
            person.setSalary(randomSalary);
            session.save(person);
        }
        transaction.commit();

        List list = session.createSQLQuery("select * from PERSONS").list();
        Assert.assertNotNull(list);

        session.close();
    }


}
