package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.IStatusDAO;
import com.solvd.deliveryservice.databasemodel.order.Status;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MStatusDAO implements IStatusDAO {
    private static final Logger LOGGER = LogManager.getLogger(MStatusDAO.class);


    @Override
    public Status findById(int id) {
        Status status = null;
        SqlSession session = null;
        try{
            session = getSession();
            IStatusDAO mapper = session.getMapper(IStatusDAO.class);
            status = mapper.findById(id);
            session.commit();
            return status;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return status;
    }


    @Override
    public void insert(Status status) {
        SqlSession session = null;
        try{
            session = getSession();
            IStatusDAO mapper = session.getMapper(IStatusDAO.class);
            mapper.insert(status);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(Status status) {
        SqlSession session = null;
        try{
            session = getSession();
            IStatusDAO mapper = session.getMapper(IStatusDAO.class);
            mapper.update(status);
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
            IStatusDAO mapper = session.getMapper(IStatusDAO.class);
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

