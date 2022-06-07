package com.solvd.deliveryservice.databasemodel.place;

import com.solvd.deliveryservice.databasemodel.address.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Restaurant {
    private static final Logger LOGGER = LogManager.getLogger(Restaurant.class);

    private int id;
    private String name;
    private String phoneNumber;
    private Double rating;
    private Address address;

    public Restaurant(){

    }

    public Restaurant(int id, String name,String phoneNumber, Double rating, Address address){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.address = address;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
