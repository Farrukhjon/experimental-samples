package org.farrukh.examples.spring.data.access.jdbc.dao;

import org.farrukh.examples.spring.data.access.jdbc.dto.City;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class CityDaoImplByNamedParam extends NamedParameterJdbcDaoSupport implements CityDao {

    public CityDaoImplByNamedParam(final DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public City save(final City city) {
        String sql = "insert into city(name, countryCode, district, population) values(:name, :countryCode, :district, :population)";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(city);
        getNamedParameterJdbcTemplate().update(sql, paramSource);
        return city;
    }

    @Override
    public List<Map<String, Object>> findAll() {
        return null;
    }

}
