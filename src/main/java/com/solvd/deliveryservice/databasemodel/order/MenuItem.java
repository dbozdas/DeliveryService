package com.solvd.deliveryservice.databasemodel.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlElement;

public class MenuItem {
    private static final Logger LOGGER = LogManager.getLogger(MenuItem.class);

    @JsonProperty
    @XmlElement(name="id")
    private int id;

    @JsonProperty
    @XmlElement(name="foodname")
    private String name;

    @JsonProperty
    @XmlElement(name="foodprice")
    private Double price;

    @JsonProperty
    @XmlElement(name="size")
    private String size;

    @JsonProperty
    @XmlElement(name="notes")
    private String specialInst;

    public MenuItem(){

    }

    public MenuItem(int id, String name, Double price, String size,
                    String specialInst)  {
    this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.specialInst = specialInst;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSpecialInst() {
        return specialInst;
    }

    public void setSpecialInst(String specialInst) {
        this.specialInst = specialInst;
    }
}
