package org.farrukh.experiments.hibernate3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractBaseTest {

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
        properties.load(ClassLoader.getSystemResourceAsStream(getUnitTestProperties()));
        Set<Object> keys = properties.keySet();
        for (Object key : keys) {
            System.setProperty((String) key, (String) properties.get(key));
        }
    }

    protected abstract String getUnitTestProperties();


    protected final SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    public void doInHibernate(Consumer<Session> callable) {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();

            callable.accept(session);
            tx.commit();
            session.close();
        } catch (Exception e) {
            tx.rollback();
            session.close();
            e.printStackTrace();
        }
    }

    public <T> T doInHibernate(Function<Session, T> callable) {
        Session session = null;
        Transaction tx = null;
        T result = null;
        try {
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();

            result = callable.apply(session);
            tx.commit();
            session.close();
        } catch (Exception e) {
            tx.rollback();
            session.close();
            e.printStackTrace();
        }
        return result;
    }

}
