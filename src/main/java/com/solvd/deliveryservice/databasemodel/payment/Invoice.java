package com.solvd.deliveryservice.databasemodel.payment;

import com.solvd.deliveryservice.databasemodel.order.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Date;

public class Invoice {
    private static final Logger LOGGER = LogManager.getLogger(Invoice.class);

    private int id;
    private Double orderAmount;
    private Double discount;
    private Double tax;
    private Double totalAmount;
    private Date invoiceDate;
    private Order order;


    public Invoice(){

    }

    public Invoice(int id, Double orderAmount, Double discount,
                   Double tax, Double totalAmount, Date invoiceDate,Order order){
        this.id = id;
        this.orderAmount = orderAmount;
        this.discount = discount;
        this.tax = tax;
        this.totalAmount = totalAmount;
        this.invoiceDate = invoiceDate;
        this.order = order;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
