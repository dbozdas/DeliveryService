package com.solvd.deliveryservice.databasemodel.vehicle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.Objects;

public class Insurance {
    private static final Logger LOGGER = LogManager.getLogger(Insurance.class);

    private int id;
    private Date effDate;
    private Date expDate;
    private Double coverage;


    public Insurance(){

    }

    public Insurance(int id, Date effDate,Date expDate, Double coverage) {
        this.id = id;
        this.effDate = effDate;
        this.expDate = expDate;
        this.coverage = coverage;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.sql.Date getEffDate() {
        return (java.sql.Date) effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public java.sql.Date getExpDate() {
        return (java.sql.Date) expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Double getCoverage() {
        return coverage;
    }

    public void setCoverage(Double coverage) {
        this.coverage = coverage;
    }


}
