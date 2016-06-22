package org.farrukh.examples.spring.data.access.jdbc.dto;

/**
 * Created by Farrukhjon on 04-Oct-15.
 */
public class Country {

    private String code;
    private String name;
    private Continent continent;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
