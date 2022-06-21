package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.ICustomerDAO;
import com.solvd.deliveryservice.databasemodel.people.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MCustomerDAO implements ICustomerDAO {
    private static final Logger LOGGER = LogManager.getLogger(MCustomerDAO.class);


    @Override
    public Customer findById(int id) {
        Customer customer = null;
        SqlSession session = null;
        try{
            session = getSession();
            ICustomerDAO mapper = session.getMapper(ICustomerDAO.class);
            customer = mapper.findById(id);
            session.commit();
            return customer;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return customer;
    }


    @Override
    public void insert(Customer customer) {
        SqlSession session = null;
        try{
            session = getSession();
            ICustomerDAO mapper = session.getMapper(ICustomerDAO.class);
            mapper.insert(customer);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(Customer customer) {
        SqlSession session = null;
        try{
            session = getSession();
            ICustomerDAO mapper = session.getMapper(ICustomerDAO.class);
            mapper.update(customer);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }
    

    @Override
    public void delete(int id) {
        SqlSession session = null;
        try{
            session = getSession();
            ICustomerDAO mapper = session.getMapper(ICustomerDAO.class);
            mapper.delete(id);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

}
