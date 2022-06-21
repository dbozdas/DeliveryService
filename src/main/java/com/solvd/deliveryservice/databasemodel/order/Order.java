package com.solvd.deliveryservice.databasemodel.order;

import com.solvd.deliveryservice.databasemodel.people.Customer;
import com.solvd.deliveryservice.databasemodel.place.Restaurant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Driver;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class Order {
    private static final Logger LOGGER = LogManager.getLogger(Order.class);

    private int id;
    private Timestamp orderDate;
    private String specialInst;
    private Customer customer;
    private Driver driver;
    private Status status;
    private Restaurant restaurant;

    public Order(){

    }

    public Order(int id, Timestamp orderDate, String specialInst,
                 Customer customer, Driver driver, Status status, Restaurant restaurant)  {
        this.id = id;
        this.orderDate = orderDate;
        this.specialInst = specialInst;
        this.customer = customer;
        this.driver = driver;
        this.restaurant = restaurant;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getSpecialInst() {
        return specialInst;
    }

    public void setSpecialInst(String specialInst) {
        this.specialInst = specialInst;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", specialInst='" + specialInst + '\'' +
                ", customer=" + customer +
                ", driver=" + driver +
                ", status=" + status +
                ", restaurant=" + restaurant +
                '}';
    }
}
