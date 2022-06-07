package com.solvd.deliveryservice.databasemodel.payment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Payment {
    private static final Logger LOGGER = LogManager.getLogger(Payment.class);

    private int id;
    private Double totalAmount;
    private String paymentType;

    public Payment(){

    }

    public Payment(int id, Double totalAmount, String paymentType) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.paymentType = paymentType;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
