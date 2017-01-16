package org.farrukh.experiments.old.tech.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REGIONS")
public class Region {

    @Id
    @Column(name = "REGION_ID", nullable = false)
    private BigDecimal id;

    @Column(name = "REGION_NAME")
    private String name;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Region [id=")
               .append(id)
               .append(", name=")
               .append(name)
               .append("]");
        return builder.toString();
    }

}
