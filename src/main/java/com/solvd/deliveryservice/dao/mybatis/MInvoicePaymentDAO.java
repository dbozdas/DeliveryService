package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.IInvoicePaymentDAO;
import com.solvd.deliveryservice.databasemodel.payment.InvoicePayment;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MInvoicePaymentDAO implements IInvoicePaymentDAO {
    private static final Logger LOGGER = LogManager.getLogger(MInvoicePaymentDAO.class);


    @Override
    public InvoicePayment findById(int id) {
        InvoicePayment invoicePayment = null;
        SqlSession session = null;
        try{
            session = getSession();
            IInvoicePaymentDAO mapper = session.getMapper(IInvoicePaymentDAO.class);
            invoicePayment = mapper.findById(id);
            session.commit();
            return invoicePayment;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return invoicePayment;
    }


    @Override
    public void insert(InvoicePayment invoicePayment) {
        SqlSession session = null;
        try{
            session = getSession();
            IInvoicePaymentDAO mapper = session.getMapper(IInvoicePaymentDAO.class);
            mapper.insert(invoicePayment);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(InvoicePayment invoicePayment) {
        SqlSession session = null;
        try{
            session = getSession();
            IInvoicePaymentDAO mapper = session.getMapper(IInvoicePaymentDAO.class);
            mapper.update(invoicePayment);
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
            IInvoicePaymentDAO mapper = session.getMapper(IInvoicePaymentDAO.class);
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

