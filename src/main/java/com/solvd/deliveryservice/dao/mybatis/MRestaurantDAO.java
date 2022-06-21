package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.IRestaurantDAO;
import com.solvd.deliveryservice.databasemodel.place.Restaurant;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MRestaurantDAO implements IRestaurantDAO {
    private static final Logger LOGGER = LogManager.getLogger(MRestaurantDAO.class);


    @Override
    public Restaurant findById(int id) {
        Restaurant restaurant = null;
        SqlSession session = null;
        try{
            session = getSession();
            IRestaurantDAO mapper = session.getMapper(IRestaurantDAO.class);
            restaurant = mapper.findById(id);
            session.commit();
            return restaurant;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return restaurant;
    }


    @Override
    public void insert(Restaurant restaurant) {
        SqlSession session = null;
        try{
            session = getSession();
            IRestaurantDAO mapper = session.getMapper(IRestaurantDAO.class);
            mapper.insert(restaurant);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(Restaurant restaurant) {
        SqlSession session = null;
        try{
            session = getSession();
            IRestaurantDAO mapper = session.getMapper(IRestaurantDAO.class);
            mapper.update(restaurant);
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
            IRestaurantDAO mapper = session.getMapper(IRestaurantDAO.class);
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

