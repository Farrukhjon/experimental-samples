package org.farrukh.experiments.hibernate3.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtil {
    
    private final SessionFactory sessionFactory = buildSessionFactory();

    private SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        return configuration.configure().buildSessionFactory();
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
