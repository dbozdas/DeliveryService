package com.solvd.deliveryservice.mybatis;

import com.solvd.deliveryservice.dao.interfaceDAO.peopleDAO.ICustomerDAO;
import com.solvd.deliveryservice.databasemodel.people.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.mybatis.MyBatisInit.getSession;


public class MyBatis {
    private static final Logger LOGGER = LogManager.getLogger(MyBatis.class);

    public Customer findCustomerById(int customerId) throws Exception {
        ICustomerDAO customerMapper = getSession().getMapper(ICustomerDAO .class);
        return customerMapper.findById(customerId);
    }

    public void insertCustomer(Customer customer) throws Exception {
        ICustomerDAO customerMapper = getSession().getMapper(ICustomerDAO .class);
        customerMapper.insert(customer);
    }

    public void updateCustomer(Customer customer) throws Exception {
        ICustomerDAO  customerMapper = getSession().getMapper(ICustomerDAO .class);
        customerMapper.update(customer);
    }

    public void deleteCustomer(int customerId) throws Exception {
        ICustomerDAO  customerMapper = getSession().getMapper(ICustomerDAO .class);
        customerMapper.delete(customerId);
    }


}
