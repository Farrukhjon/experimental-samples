package org.farrukh.experiments.spring.orm.service;

import java.util.List;

import org.farrukh.experiments.spring.orm.dao.ICountryDao;
import org.farrukh.experiments.spring.orm.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryService {

    @Autowired
    private ICountryDao countryDao;
    
    public List<Country> findAll() {
        return countryDao.findAll();
    }

    public void save(Country aCountry) {
        countryDao.create(aCountry);
        
        countryDao.update(aCountry);
    }

    public void update(Country aCountry) {
        countryDao.update(aCountry);
    }

    public Country retrieve(String id) {
        return countryDao.findOne(id);
    }
    
    
}
