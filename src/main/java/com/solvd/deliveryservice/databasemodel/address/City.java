package com.solvd.deliveryservice.databasemodel.address;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class City {
    private static final Logger LOGGER = LogManager.getLogger(City.class);

    private int id;
    private String name;
    private State state;

    public City(){

    }

    public City(int id, String name, State state) {
        this.id = id;
        this.name = name;
        this.state = state;

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
