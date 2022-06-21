package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.IZipCodeDAO;
import com.solvd.deliveryservice.databasemodel.address.ZipCode;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MZipCodeDAO implements IZipCodeDAO {
    private static final Logger LOGGER = LogManager.getLogger(MZipCodeDAO.class);


    @Override
    public ZipCode findById(int id) {
        ZipCode zipCode = null;
        SqlSession session = null;
        try{
            session = getSession();
            IZipCodeDAO mapper = session.getMapper(IZipCodeDAO.class);
            zipCode = mapper.findById(id);
            session.commit();
            return zipCode;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return zipCode;
    }


    @Override
    public void insert(ZipCode zipCode) {
        SqlSession session = null;
        try{
            session = getSession();
            IZipCodeDAO mapper = session.getMapper(IZipCodeDAO.class);
            mapper.insert(zipCode);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(ZipCode zipCode) {
        SqlSession session = null;
        try{
            session = getSession();
            IZipCodeDAO mapper = session.getMapper(IZipCodeDAO.class);
            mapper.update(zipCode);
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
            IZipCodeDAO mapper = session.getMapper(IZipCodeDAO.class);
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

