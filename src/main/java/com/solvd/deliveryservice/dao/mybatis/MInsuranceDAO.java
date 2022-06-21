package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.IInsuranceDAO;
import com.solvd.deliveryservice.databasemodel.vehicle.Insurance;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MInsuranceDAO implements IInsuranceDAO {
    private static final Logger LOGGER = LogManager.getLogger(MInsuranceDAO.class);


    @Override
    public Insurance findById(int id) {
        Insurance insurance = null;
        SqlSession session = null;
        try{
            session = getSession();
            IInsuranceDAO mapper = session.getMapper(IInsuranceDAO.class);
            insurance = mapper.findById(id);
            session.commit();
            return insurance;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return insurance;
    }


    @Override
    public void insert(Insurance insurance) {
        SqlSession session = null;
        try{
            session = getSession();
            IInsuranceDAO mapper = session.getMapper(IInsuranceDAO.class);
            mapper.insert(insurance);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(Insurance insurance) {
        SqlSession session = null;
        try{
            session = getSession();
            IInsuranceDAO mapper = session.getMapper(IInsuranceDAO.class);
            mapper.update(insurance);
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
            IInsuranceDAO mapper = session.getMapper(IInsuranceDAO.class);
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

