package org.farrukh.experiments.spring.orm.hibernate3.config;

import static org.hibernate.cfg.Environment.DIALECT;
import static org.hibernate.cfg.Environment.HBM2DDL_AUTO;
import static org.hibernate.cfg.Environment.SHOW_SQL;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

@Configuration
@EnableTransactionManagement // Enables Spring's annotation-driven transaction
                             // management (like <tx:*/> in xml config).
@PropertySource({
    "oracle.properties",
    "hibernate.properties"
    })
@ComponentScan({
    "org.farrukh.experiments.spring.orm.hibernate3.dao",
    "org.farrukh.experiments.spring.orm.service"
    })
@EnableCaching
public class SpringHibernateJavaConfig {
    
    @Autowired
    private Environment env;

    private static final String ANNOT_MODEL_PATH = "org.farrukh.experiments.spring.orm.model";

    @Bean
    public DataSource dataSource() {
        try {
            OracleConnectionPoolDataSource oracle = new OracleConnectionPoolDataSource();
            oracle.setServerName(env.getProperty("oracle.server.name"));
            oracle.setServiceName(env.getProperty("oracle.service.name"));
            oracle.setPortNumber(env.getProperty("oracle.port.number", Integer.class));
            oracle.setDatabaseName(env.getProperty("oracle.database.name"));
            oracle.setUser(env.getProperty("oracle.user"));
            oracle.setPassword(env.getProperty("oracle.password"));
            oracle.setDriverType(env.getProperty("oracle.driver.type"));
            return oracle;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty(DIALECT, env.getProperty(DIALECT));
        properties.setProperty(SHOW_SQL, env.getProperty(SHOW_SQL));
        properties.setProperty(HBM2DDL_AUTO, env.getProperty(HBM2DDL_AUTO));
        return properties;
    }

    @Bean
    public AnnotationSessionFactoryBean sessionFactoryBean(final DataSource dataSource) {
        AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan(ANNOT_MODEL_PATH);
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }
    
    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager(final SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    @Bean
    public EhCacheManagerFactoryBean cacheManagerFactory() {
        EhCacheManagerFactoryBean ehCacheManagerFactory = new EhCacheManagerFactoryBean();
        ehCacheManagerFactory.setConfigLocation(new ClassPathResource("ehcache.xml"));
        ehCacheManagerFactory.setShared(true);
        return ehCacheManagerFactory;
    }
    
    @Bean
    public CacheManager cacheManager() {
        net.sf.ehcache.CacheManager cacheManager = cacheManagerFactory().getObject();
        return new EhCacheCacheManager(cacheManager);
    }

}
