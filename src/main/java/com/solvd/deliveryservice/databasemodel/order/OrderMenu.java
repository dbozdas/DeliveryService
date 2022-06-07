package com.solvd.deliveryservice.databasemodel.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderMenu {
    private static final Logger LOGGER = LogManager.getLogger(OrderMenu.class);

    private int id;
    private Order order;
    private MenuItem menuItem;

    public OrderMenu(){

    }

    public OrderMenu(int id, Order order, MenuItem menuItem)  {
        this.id = id;
        this.order = order;
        this.menuItem = menuItem;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
}
