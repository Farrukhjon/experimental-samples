package org.farrukh.examples.spring.data.access.jdbc;

import org.farrukh.examples.spring.data.access.jdbc.dao.CityDao;
import org.farrukh.examples.spring.data.access.jdbc.dto.City;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class CityDaoTests extends BaseTest {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private CityDao cityDaoByNamedParam;

    @Test
    public void testCityDao() {
        Assert.assertNotNull(cityDao);
    }

    @Test
    public void testSaveCity() {
        City city = new City();
        city.setName("Khujand");
        cityDao.save(city);

        List<Map<String, Object>> cities = cityDao.findAll();
        System.out.println(cities);
    }

    @Test
    public void testSaveCityByNamedParam() {
        City city = new City();
        city.setName("Paris");
        cityDaoByNamedParam.save(city);

        List<Map<String, Object>> cities = cityDao.findAll();
        System.out.println(cities);
    }

}
