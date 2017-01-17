package org.farrukh.experiments.spring.orm.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JOBS")
public class Job {
    
    @Id
    @Column(name = "JOB_ID")
    private String id;
    
    @Column(name = "JOB_TITLE")
    private String title;
    
    @Column(name = "MIN_SALARY")
    private BigDecimal minSalary;
    
    @Column(name = "MAX_SALARY")
    private BigDecimal maxSalary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public BigDecimal getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Job [id=")
               .append(id)
               .append(", title=")
               .append(title)
               .append("]");
        return builder.toString();
    }

}
