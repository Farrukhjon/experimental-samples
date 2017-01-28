package org.farrukh.experiments.orm.hibernate3.query.hql;

import java.math.BigDecimal;

public class ShortReportData {
    
    public BigDecimal id;
    public String name;
    public String last;
    
    public ShortReportData(BigDecimal id, String name, String last) {
        this.id = id;
        this.name = name;
        this.last = last;
    }
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
    public String getLast() {
        return last;
    }
    public void setLast(String last) {
        this.last = last;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ShortReportData [id=")
               .append(id)
               .append(", name=")
               .append(name)
               .append(", last=")
               .append(last)
               .append("]");
        return builder.toString();
    }
    
    
    
    
}