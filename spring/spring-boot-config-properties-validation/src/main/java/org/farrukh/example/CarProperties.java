package org.farrukh.example;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "car")
public class CarProperties {

    private String manufacturer;

    private int seatCount = 2;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(final String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(final int seatCount) {
        this.seatCount = seatCount;
    }
}
