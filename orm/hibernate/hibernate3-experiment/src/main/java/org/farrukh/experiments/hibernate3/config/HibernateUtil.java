package org.farrukh.experiments.hibernate3.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtil {
    
    private final SessionFactory sessionFactory = buildSessionFactory();

    private final String configResource;

    public HibernateUtil(String configResource) {
        this.configResource = configResource;
    }

    public HibernateUtil() {
        this("hibernate.cfg.xml");
    }

    private SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        return configuration.configure(configResource).buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void main(String[] args) {
        Session session = new HibernateUtil().getSessionFactory().openSession();
        
        session.beginTransaction();
        
        session.getTransaction().commit();
        
        session.close();
        
    }
    
    

}
