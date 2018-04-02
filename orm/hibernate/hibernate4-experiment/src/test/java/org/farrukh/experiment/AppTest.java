package org.farrukh.experiment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.junit.Test;

import java.util.Properties;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private SessionFactory sessionFactory;

    public void setUp() throws Exception {
        Properties properties = getLocalOracleProperties();
        sessionFactory = App.createSessionFactory(properties);
    }

    private Properties getLocalOracleProperties() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.Oracle10gDialect");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "");
        properties.put(Environment.URL, "");
        properties.put(Environment.DRIVER, "");
        properties.put(Environment.SHOW_SQL, "true");
        return properties;
    }

    @Test
    public void test() {
        Session session = sessionFactory.openSession();


    }
}
