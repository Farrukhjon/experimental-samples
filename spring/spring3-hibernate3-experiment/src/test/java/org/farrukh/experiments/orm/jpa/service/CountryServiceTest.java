package org.farrukh.experiments.orm.jpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.farrukh.experiments.orm.jpa.config.SpringJPAContextJavaConfigTest;
import org.farrukh.experiments.spring.orm.model.Country;
import org.farrukh.experiments.spring.orm.model.Region;
import org.farrukh.experiments.spring.orm.service.CountryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryServiceTest extends SpringJPAContextJavaConfigTest {

    @Autowired
    private CountryService service;

    @Test
    public void shouldReturnAllCountries() throws Exception {
        List<Country> countries = service.findAll();
        int count = countries.size();
        assertTrue(count > 0);
        int expectedCountOfCountries = 25;
        assertEquals(expectedCountOfCountries, count);
    }
    
    @Test
    public void shouldInsertACountry() throws Exception {
        Country tj = new Country();
        tj.setId("TJ");
        tj.setName("Tajikistan");
        /*Region asia = new Region();
        asia.setId(new BigDecimal(3));
        asia.setName("Asia");
        tj.setRegion(asia);*/
        service.save(tj);
    }
    
    @Test
    public void shouldUpdateACountry() throws Exception {
        Country country = service.retrieve("UZ");
        Region asia = new Region();
        asia.setId(new BigDecimal(3));
        asia.setName("Asia");
        country.setRegion(asia);
        service.update(country);
    }

}
