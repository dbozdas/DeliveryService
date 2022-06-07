package com.solvd.deliveryservice.service;

import com.solvd.deliveryservice.dao.implDAO.peopleDAO.CustomerDAO;
import com.solvd.deliveryservice.dao.interfaceDAO.orderDAO.IOrderDAO;
import com.solvd.deliveryservice.dao.interfaceDAO.peopleDAO.ICustomerDAO;
import com.solvd.deliveryservice.databasemodel.people.Customer;
import com.solvd.deliveryservice.dao.implDAO.orderDAO.OrderDAO;

public class CustomerService {
    private ICustomerDAO iCustomerDAO = (ICustomerDAO) new CustomerDAO();
    private IOrderDAO iOrderDAO = (IOrderDAO) new OrderDAO();


    public Customer getCustomerById(int id) throws Exception {
        Customer result = null;
        result = iCustomerDAO.findById(id);
        result.setOrders(iOrderDAO.getOrdersByCustomerId(id));
        return result;

    }
}
