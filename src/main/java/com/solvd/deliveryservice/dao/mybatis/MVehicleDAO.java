package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.IVehicleDAO;
import com.solvd.deliveryservice.databasemodel.vehicle.Vehicle;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MVehicleDAO implements IVehicleDAO {
    private static final Logger LOGGER = LogManager.getLogger(MVehicleDAO.class);


    @Override
    public Vehicle findById(int id) {
        Vehicle vehicle = null;
        SqlSession session = null;
        try{
            session = getSession();
            IVehicleDAO mapper = session.getMapper(IVehicleDAO.class);
            vehicle = mapper.findById(id);
            session.commit();
            return vehicle;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return vehicle;
    }


    @Override
    public void insert(Vehicle vehicle) {
        SqlSession session = null;
        try{
            session = getSession();
            IVehicleDAO mapper = session.getMapper(IVehicleDAO.class);
            mapper.insert(vehicle);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(Vehicle vehicle) {
        SqlSession session = null;
        try{
            session = getSession();
            IVehicleDAO mapper = session.getMapper(IVehicleDAO.class);
            mapper.update(vehicle);
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
            IVehicleDAO mapper = session.getMapper(IVehicleDAO.class);
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

