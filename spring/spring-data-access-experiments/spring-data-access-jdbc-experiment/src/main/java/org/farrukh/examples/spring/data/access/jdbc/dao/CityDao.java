package org.farrukh.examples.spring.data.access.jdbc.dao;

import org.farrukh.examples.spring.data.access.jdbc.dto.City;

import java.util.List;
import java.util.Map;

public interface CityDao {

    City save(final City city);

    List<Map<String, Object>> findAll();

}
