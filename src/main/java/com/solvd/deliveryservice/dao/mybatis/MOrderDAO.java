package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.IOrderDAO;
import com.solvd.deliveryservice.databasemodel.order.Order;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MOrderDAO implements IOrderDAO {
    private static final Logger LOGGER = LogManager.getLogger(MOrderDAO.class);


    @Override
    public Order findById(int id) {
        Order order = null;
        SqlSession session = null;
        try{
            session = getSession();
            IOrderDAO mapper = session.getMapper(IOrderDAO.class);
            order = mapper.findById(id);
            session.commit();
            return order;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return order;
    }


    @Override
    public void insert(Order order) {
        SqlSession session = null;
        try{
            session = getSession();
            IOrderDAO mapper = session.getMapper(IOrderDAO.class);
            mapper.insert(order);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(Order order) {
        SqlSession session = null;
        try{
            session = getSession();
            IOrderDAO mapper = session.getMapper(IOrderDAO.class);
            mapper.update(order);
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
            IOrderDAO mapper = session.getMapper(IOrderDAO.class);
            mapper.delete(id);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public Object getOrdersByCustomerId(int id) {
        return null;
    }

    @Override
    public Object getOrdersByDriverId(int id) {
        return null;
    }
}

