package org.farrukh.experiments.old.tech.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.farrukh.experiments.old.tech.AppContextConfigTests;
import org.farrukh.experiments.old.tech.model.Country;
import org.farrukh.experiments.old.tech.service.CountryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class CountryServiceTest extends AppContextConfigTests {
    
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

}
