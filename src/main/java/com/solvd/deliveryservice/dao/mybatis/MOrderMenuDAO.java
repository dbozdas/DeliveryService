package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.IOrderMenuDAO;
import com.solvd.deliveryservice.databasemodel.order.OrderMenu;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MOrderMenuDAO implements IOrderMenuDAO {
    private static final Logger LOGGER = LogManager.getLogger(MOrderMenuDAO.class);


    @Override
    public OrderMenu findById(int id) {
        OrderMenu orderMenu = null;
        SqlSession session = null;
        try{
            session = getSession();
            IOrderMenuDAO mapper = session.getMapper(IOrderMenuDAO.class);
            orderMenu = mapper.findById(id);
            session.commit();
            return orderMenu;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return orderMenu;
    }


    @Override
    public void insert(OrderMenu orderMenu) {
        SqlSession session = null;
        try{
            session = getSession();
            IOrderMenuDAO mapper = session.getMapper(IOrderMenuDAO.class);
            mapper.insert(orderMenu);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(OrderMenu orderMenu) {
        SqlSession session = null;
        try{
            session = getSession();
            IOrderMenuDAO mapper = session.getMapper(IOrderMenuDAO.class);
            mapper.update(orderMenu);
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
            IOrderMenuDAO mapper = session.getMapper(IOrderMenuDAO.class);
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

