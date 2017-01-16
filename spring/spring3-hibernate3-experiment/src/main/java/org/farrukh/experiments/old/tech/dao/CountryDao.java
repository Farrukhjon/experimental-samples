package org.farrukh.experiments.old.tech.dao;

import org.farrukh.experiments.old.tech.model.Country;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDao extends AbstractHibernateDao<Country> implements ICountryDao {

    public CountryDao() {
        super(Country.class);
    }

}
