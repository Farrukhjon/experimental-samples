package org.farrukh.experiments.old.tech.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATIONS")
public class Location {
    
    @Id
    @Column(name = "LOCATION_ID")
    private BigDecimal id;
    
    @Column(name = "COUNTRY_ID")
    @OneToMany
    @JoinColumn(name = "COUNTRY_ID")
    private List<Country> countries;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Location [id=")
               .append(id)
               .append(", countries=")
               .append(countries)
               .append("]");
        return builder.toString();
    }
    
}
