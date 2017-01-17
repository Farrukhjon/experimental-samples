package org.farrukh.examples.spring.data.access.jdbc.mapper;


import org.farrukh.examples.spring.data.access.jdbc.dto.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRowMapper implements RowMapper<City> {

    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        City city = new City();
        city.setId(rs.getInt("ID"));
        city.setName(rs.getString("Name"));
        city.setCountryCode(rs.getString("CountryCode"));
        city.setDistrict(rs.getString("District"));
        city.setPopulation(rs.getInt("Population"));
        return city;
    }

}
