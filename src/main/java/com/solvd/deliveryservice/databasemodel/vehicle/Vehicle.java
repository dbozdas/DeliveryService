package com.solvd.deliveryservice.databasemodel.vehicle;

import com.solvd.deliveryservice.databasemodel.people.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class Vehicle {
    private static final Logger LOGGER = LogManager.getLogger(Vehicle.class);

    private int id;
    private String plateNumber;
    private String make;
    private String model;
    private int year;
    private Date inspectionExpDate;
    private Driver driver;
    private Insurance insurance;

    public Vehicle(){

    }

    public Vehicle(int id, String plateNumber,String make, String model,
                      int year, Date inspectionExpDate, Driver driver, Insurance insurance) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.inspectionExpDate =inspectionExpDate ;
        this.driver = driver;
        this.insurance = insurance;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public java.sql.Date getInspectionExpDate() {
        return (java.sql.Date) inspectionExpDate;
    }

    public void setInspectionExpDate(Date inspectionExpDate) {
        this.inspectionExpDate = inspectionExpDate;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
