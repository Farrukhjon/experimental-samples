package org.farrukh.examples.spring.data.access.jdbc;

import org.farrukh.examples.spring.data.access.jdbc.dto.City;
import org.farrukh.examples.spring.data.access.jdbc.mapper.CityRowMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/**
 * RowMapper test illustration result mapping to the object.
 */
public class RowMapperTests extends BaseTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    public void testSingleRowMapper() {
        City expectedCity = new City();
        expectedCity.setId(3261);
        expectedCity.setName("Dushanbe");
        expectedCity.setCountryCode("TJK");
        expectedCity.setDistrict("Karotegin");
        expectedCity.setPopulation(524000);

        City mappedCityById = getMappedCityById(3261);

        assertEquals(expectedCity, mappedCityById);
    }

    @Test
    public void testMultipleRowMapper() {
        String sql = "select * from city";
        List<City> cities = jdbcTemplate.query(sql, new CityRowMapper());
        int rowCount = jdbcTemplate.queryForObject("select count(*) from city", Integer.class);
        assertEquals(cities.size(), rowCount);
    }

    private City getMappedCityById(int id) {
        String slq = "select * from city where id = ?";
        return jdbcTemplate.queryForObject(slq, new Object[]{id}, new CityRowMapper());
    }

}
