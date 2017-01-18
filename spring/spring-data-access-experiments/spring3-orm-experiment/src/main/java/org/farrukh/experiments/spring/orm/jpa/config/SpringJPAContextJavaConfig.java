package org.farrukh.experiments.spring.orm.jpa.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

@Configuration
@PropertySource({ "oracle.properties", "hibernate.properties" })
@ComponentScan({
    "org.farrukh.experiments.spring.orm.jpa.dao",
    "org.farrukh.experiments.spring.orm.service"
    })
@EnableTransactionManagement
public class SpringJPAContextJavaConfig {

    @Autowired
    private Environment env;

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
            throw new RuntimeException(e);
        }
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean(final DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSource);
        lcemfb.setPersistenceProvider(new HibernatePersistence());
        lcemfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        lcemfb.setJpaDialect(new HibernateJpaDialect());
        lcemfb.setPackagesToScan("org.farrukh.experiments.spring.orm.model");
        LoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
        lcemfb.setLoadTimeWeaver(loadTimeWeaver);
        return lcemfb;
    }

    @Bean
    public JpaTransactionManager jpaTransactionManager(LocalContainerEntityManagerFactoryBean lcemfb) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(lcemfb.getObject());
        return jpaTransactionManager;
    }

}
