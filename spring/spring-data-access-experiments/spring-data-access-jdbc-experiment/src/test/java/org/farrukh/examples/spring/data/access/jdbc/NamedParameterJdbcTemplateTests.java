package org.farrukh.examples.spring.data.access.jdbc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * Test class for exercising NamedParameterJdbcTemplate methods.
 */
public class NamedParameterJdbcTemplateTests extends BaseTest {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    public void testQueryForObject() {
        long populationOfEurope = sumCountryPopulationByContinent("Europe");
        long populationOfAsia = sumCountryPopulationByContinent("Asia");
        assertEquals(730074600, populationOfEurope);
        assertEquals(3705025700L, populationOfAsia);
    }

    /**
     * Gets sum of country's population by continent (named parameter).
     * @param continent - serves as Named Parameter
     * @return sum of calculation.
     */
    public long sumCountryPopulationByContinent(String continent) {
        String sql = "select sum(c.Population) as population from country c where c.Continent = :continent";
        SqlParameterSource paramSource = new MapSqlParameterSource("continent", continent);
        return namedParameterJdbcTemplate.queryForObject(sql, paramSource, Long.class);
    }
}
