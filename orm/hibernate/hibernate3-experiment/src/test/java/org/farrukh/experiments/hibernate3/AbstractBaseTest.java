package org.farrukh.experiments.hibernate3;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public abstract class AbstractBaseTest {

    private static final String unittestProperties = "unittest.properties";

    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        loadSystemProperties();
        Configuration configuration = new Configuration();
        sessionFactory = configuration.
                configure("hibernate.cfg.xml").
                buildSessionFactory();
    }

    private void loadSystemProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream(unittestProperties));
        Set<Object> keys = properties.keySet();
        for (Object key : keys) {
            System.setProperty((String) key, (String) properties.get(key));
        }
    }


    final SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
