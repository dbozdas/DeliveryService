package com.solvd.deliveryservice.databasemodel.address;

import com.solvd.deliveryservice.databasemodel.people.Customer;
import com.solvd.deliveryservice.databasemodel.people.Driver;
import com.solvd.deliveryservice.databasemodel.place.Restaurant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;

public class Address {
    private static final Logger LOGGER = LogManager.getLogger(Address.class);

    private int id;
    private String streetNumber;
    private String streetName;
    private ZipCode zipCode;

    public Address(){

    }

    public Address(int id, String streetNumber,String streetName,
                   ZipCode zipCode) {
        super();
        this.id = id;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.zipCode = zipCode;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }

}
