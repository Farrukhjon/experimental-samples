package org.farrukh.experiments.old.tech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // Enables Spring's annotation-driven transaction management (like <tx:*/> in xml config).
@PropertySource("{classpath:oracle-persistence.properties, classpath: hibernate-persistence.properties}")
public class SpringHibernateXMLConfig {

}
