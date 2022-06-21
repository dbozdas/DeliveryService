package com.solvd.deliveryservice.dao;

import com.solvd.deliveryservice.databasemodel.order.Order;

public interface IOrderDAO extends IBaseDAO<Order> {

    Object getOrdersByCustomerId(int id);

    Object getOrdersByDriverId(int id);
}

