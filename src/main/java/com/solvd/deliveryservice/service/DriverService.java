package com.solvd.deliveryservice.service;

import com.solvd.deliveryservice.dao.implDAO.orderDAO.OrderDAO;
import com.solvd.deliveryservice.dao.implDAO.peopleDAO.DriverDAO;
import com.solvd.deliveryservice.dao.interfaceDAO.orderDAO.IOrderDAO;
import com.solvd.deliveryservice.dao.interfaceDAO.peopleDAO.IDriverDAO;
import com.solvd.deliveryservice.databasemodel.people.Driver;

public class DriverService {
    private IDriverDAO iDriverDAO = (IDriverDAO) new DriverDAO();
    private IOrderDAO iOrderDAO = (IOrderDAO) new OrderDAO();


    public Driver getCustomerById(int id) throws Exception {
        Driver result = null;
        result = iDriverDAO.findById(id);
        result.setOrders(iOrderDAO.getOrdersByDriverId(id));
        return result;

    }
}
