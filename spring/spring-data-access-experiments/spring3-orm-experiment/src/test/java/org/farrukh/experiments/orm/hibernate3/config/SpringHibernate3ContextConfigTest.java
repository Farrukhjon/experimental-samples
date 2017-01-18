package org.farrukh.experiments.orm.hibernate3.config;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.farrukh.experiments.spring.orm.hibernate3.config.SpringHibernateJavaConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringHibernateJavaConfig.class, loader = AnnotationConfigContextLoader.class)
public class SpringHibernate3ContextConfigTest {
    
    @Autowired
    DataSource oracleDataSource;
    
    @Autowired
    AnnotationSessionFactoryBean sessionFactoryBean;
    
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    HibernateTransactionManager hibernateTransactionManager;
    
    @Autowired
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor;

    @Test
    public void theOraclePooledDataSourceShouldBeInstantiated() throws Exception {
        Assert.assertNotNull(oracleDataSource);
    }
    
    @Test
    public void shouldTestAnnotationSessionFactoryBeanInstantiation() throws Exception {
        assertNotNull(sessionFactoryBean);
    }

    @Test
    public void shouldTestSessionFactoryInstantiation() throws Exception {
        assertNotNull(sessionFactory);
    }

    @Test
    public void shouldTestHibernateTransactionManagerInstantiation() throws Exception {
        assertNotNull(hibernateTransactionManager);
    }
    
    @Test
    public void ShouldTestPersistenceExceptionTranslationPostProcessorInstantiation() throws Exception {
        assertNotNull(persistenceExceptionTranslationPostProcessor);
    }
    
    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

}
