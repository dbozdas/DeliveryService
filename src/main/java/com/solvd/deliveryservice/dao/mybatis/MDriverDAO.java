package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.IDriverDAO;
import com.solvd.deliveryservice.databasemodel.people.Driver;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MDriverDAO implements IDriverDAO {
    private static final Logger LOGGER = LogManager.getLogger(MDriverDAO.class);


    @Override
    public Driver findById(int id) {
        Driver driver = null;
        SqlSession session = null;
        try{
            session = getSession();
            IDriverDAO mapper = session.getMapper(IDriverDAO.class);
            driver = mapper.findById(id);
            session.commit();
            return driver;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return driver;
    }


    @Override
    public void insert(Driver driver) {
        SqlSession session = null;
        try{
            session = getSession();
            IDriverDAO mapper = session.getMapper(IDriverDAO.class);
            mapper.insert(driver);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(Driver driver) {
        SqlSession session = null;
        try{
            session = getSession();
            IDriverDAO mapper = session.getMapper(IDriverDAO.class);
            mapper.update(driver);
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
            IDriverDAO mapper = session.getMapper(IDriverDAO.class);
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

