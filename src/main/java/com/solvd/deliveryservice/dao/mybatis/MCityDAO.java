package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.ICityDAO;
import com.solvd.deliveryservice.databasemodel.address.City;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MCityDAO implements ICityDAO {
    private static final Logger LOGGER = LogManager.getLogger(MCityDAO.class);


    @Override
    public City findById(int id) {
        City city = null;
        SqlSession session = null;
        try{
            session = getSession();
            ICityDAO mapper = session.getMapper(ICityDAO.class);
            city = mapper.findById(id);
            session.commit();
            return city;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return city;
    }


    @Override
    public void insert(City city) {
        SqlSession session = null;
        try{
            session = getSession();
            ICityDAO mapper = session.getMapper(ICityDAO.class);
            mapper.insert(city);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(City city) {
        SqlSession session = null;
        try{
            session = getSession();
            ICityDAO mapper = session.getMapper(ICityDAO.class);
            mapper.update(city);
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
            ICityDAO mapper = session.getMapper(ICityDAO.class);
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

