package com.solvd.deliveryservice.databasemodel.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Status {
    private static final Logger LOGGER = LogManager.getLogger(Status.class);

    private int id;
    private String statusName;

    public Status(){

    }

    public Status(int id, String statusName)  {
        this.id = id;
        this.statusName = statusName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
