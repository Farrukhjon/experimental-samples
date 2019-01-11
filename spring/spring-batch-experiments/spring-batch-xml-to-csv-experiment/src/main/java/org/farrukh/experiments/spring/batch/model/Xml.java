package org.farrukh.experiments.spring.batch.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trade")
public class Xml {

    String isin;

    int quantity;

    double price;

    String customer;

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
