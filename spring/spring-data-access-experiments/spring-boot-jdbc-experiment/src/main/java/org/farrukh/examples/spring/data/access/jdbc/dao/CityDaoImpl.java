package org.farrukh.examples.spring.data.access.jdbc.dao;

import org.farrukh.examples.spring.data.access.jdbc.dto.City;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class CityDaoImpl extends JdbcDaoSupport implements CityDao {

    public CityDaoImpl(final DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public City save(final City city) {
        String sql = "insert into city(name, countryCode, population, district) VALUES (?, ?, ?, ?)";
        getJdbcTemplate().update(sql, city.getName(), city.getCountryCode(), city.getPopulation(), city.getDistrict());
        return city;
    }

    @Override
    public List<Map<String, Object>> findAll() {
        String sql = "SELECT * from city";
        List<Map<String, Object>> cities = getJdbcTemplate().queryForList(sql);
        return cities;
    }

}
