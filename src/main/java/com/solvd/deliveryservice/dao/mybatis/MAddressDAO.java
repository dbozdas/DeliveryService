package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.IAddressDAO;
import com.solvd.deliveryservice.databasemodel.address.Address;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MAddressDAO implements IAddressDAO {
    private static final Logger LOGGER = LogManager.getLogger(MAddressDAO.class);


    @Override
    public Address findById(int id) {
        Address address = null;
        SqlSession session = null;
        try{
            session = getSession();
            IAddressDAO mapper = session.getMapper(IAddressDAO.class);
            address = mapper.findById(id);
            session.commit();
            return address;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return address;
    }


    @Override
    public void insert(Address address) {
        SqlSession session = null;
        try{
            session = getSession();
            IAddressDAO mapper = session.getMapper(IAddressDAO.class);
            mapper.insert(address);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(Address address) {
        SqlSession session = null;
        try{
            session = getSession();
            IAddressDAO mapper = session.getMapper(IAddressDAO.class);
            mapper.update(address);
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
            IAddressDAO mapper = session.getMapper(IAddressDAO.class);
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

