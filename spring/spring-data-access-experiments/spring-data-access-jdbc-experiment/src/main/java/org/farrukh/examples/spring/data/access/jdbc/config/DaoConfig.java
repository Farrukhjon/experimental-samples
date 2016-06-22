package org.farrukh.examples.spring.data.access.jdbc.config;

import org.farrukh.examples.spring.data.access.jdbc.dao.CityDao;
import org.farrukh.examples.spring.data.access.jdbc.dao.CityDaoImpl;
import org.farrukh.examples.spring.data.access.jdbc.dao.CityDaoImplByNamedParam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DaoConfig {

    @Bean
    public CityDao cityDao(final DataSource dataSource) {
        return new CityDaoImpl(dataSource);
    }

    @Bean
    public CityDao cityDaoByNamedParam(final DataSource dataSource) {
        return new CityDaoImplByNamedParam(dataSource);
    }

}
