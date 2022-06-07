package com.solvd.deliveryservice.databasemodel.address;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ZipCode {


    private static final Logger LOGGER = LogManager.getLogger(ZipCode.class);

    private int id;
    private String zipCode;
    private City city;

    public ZipCode(){

    }

    public ZipCode(int id, String zipCode, City city) {
        this.id = id;
        this.zipCode = zipCode;
        this.city = city;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
