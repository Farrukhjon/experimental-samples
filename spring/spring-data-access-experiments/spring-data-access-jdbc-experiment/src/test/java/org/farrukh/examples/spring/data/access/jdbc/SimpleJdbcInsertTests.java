package org.farrukh.examples.spring.data.access.jdbc;

import org.farrukh.examples.spring.data.access.jdbc.dto.City;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class SimpleJdbcInsertTests extends BaseTest{

    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    @Test
    public void testInsertWithTableNameUsingGeneratedKeyColumnsExecuteAndReturnKey() {
        City city = new City();
        city.setName("Amsterdam");
        city.setCountryCode("NL");
        city.setPopulation(1234567);
        city.setDistrict("Amsterdam DC");
        Number key = simpleJdbcInsert.withTableName("city")
                                     .usingGeneratedKeyColumns("id")
                                     .executeAndReturnKey(new BeanPropertySqlParameterSource(city));
        System.out.println(key);
    }

}
