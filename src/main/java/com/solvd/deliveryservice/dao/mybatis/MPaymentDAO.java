package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.IPaymentDAO;
import com.solvd.deliveryservice.databasemodel.payment.Payment;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MPaymentDAO implements IPaymentDAO {
    private static final Logger LOGGER = LogManager.getLogger(MPaymentDAO.class);


    @Override
    public Payment findById(int id) {
        Payment payment = null;
        SqlSession session = null;
        try{
            session = getSession();
            IPaymentDAO mapper = session.getMapper(IPaymentDAO.class);
            payment = mapper.findById(id);
            session.commit();
            return payment;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return payment;
    }


    @Override
    public void insert(Payment payment) {
        SqlSession session = null;
        try{
            session = getSession();
            IPaymentDAO mapper = session.getMapper(IPaymentDAO.class);
            mapper.insert(payment);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(Payment payment) {
        SqlSession session = null;
        try{
            session = getSession();
            IPaymentDAO mapper = session.getMapper(IPaymentDAO.class);
            mapper.update(payment);
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
            IPaymentDAO mapper = session.getMapper(IPaymentDAO.class);
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

