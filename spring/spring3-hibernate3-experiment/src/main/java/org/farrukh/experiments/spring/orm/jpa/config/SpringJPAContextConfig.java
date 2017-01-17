package org.farrukh.experiments.spring.orm.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class SpringJPAContextConfig {
    
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean entityManagerFactoryBean = new LocalEntityManagerFactoryBean();
        
        String persistenceUnitName = "test-pu";
        entityManagerFactoryBean.setPersistenceUnitName(persistenceUnitName);
        
        return entityManagerFactoryBean;
    }
    
}
