package com.solvd.deliveryservice.databasemodel.payment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvoicePayment {
    private static final Logger LOGGER = LogManager.getLogger(InvoicePayment.class);

    private int id;
    private Invoice invoice;
    private Payment payment;

    public InvoicePayment(){

    }

    public InvoicePayment(int id, Invoice invoice, Payment payment) {
        this.id = id;
        this.invoice = invoice;
        this.payment = payment;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
