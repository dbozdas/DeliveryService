package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.IAvailableHourDAO;
import com.solvd.deliveryservice.databasemodel.calendar.AvailableHour;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MAvailableHourDAO implements IAvailableHourDAO {
    private static final Logger LOGGER = LogManager.getLogger(MAvailableHourDAO.class);


    @Override
    public AvailableHour findById(int id) {
        AvailableHour availableHour = null;
        SqlSession session = null;
        try{
            session = getSession();
            IAvailableHourDAO mapper = session.getMapper(IAvailableHourDAO.class);
            availableHour = mapper.findById(id);
            session.commit();
            return availableHour;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return availableHour;
    }


    @Override
    public void insert(AvailableHour availableHour) {
        SqlSession session = null;
        try{
            session = getSession();
            IAvailableHourDAO mapper = session.getMapper(IAvailableHourDAO.class);
            mapper.insert(availableHour);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(AvailableHour availableHour) {
        SqlSession session = null;
        try{
            session = getSession();
            IAvailableHourDAO mapper = session.getMapper(IAvailableHourDAO.class);
            mapper.update(availableHour);
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
            IAvailableHourDAO mapper = session.getMapper(IAvailableHourDAO.class);
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

