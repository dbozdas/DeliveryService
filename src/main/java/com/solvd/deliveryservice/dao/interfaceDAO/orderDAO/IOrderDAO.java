package com.solvd.deliveryservice.dao.interfaceDAO.orderDAO;

import com.solvd.deliveryservice.dao.interfaceDAO.IBaseDAO;
import com.solvd.deliveryservice.databasemodel.order.Order;

public interface IOrderDAO extends IBaseDAO<Order> {

    Object getOrdersByCustomerId(int id);

    Object getOrdersByDriverId(int id);
}

