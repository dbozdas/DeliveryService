package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.IInvoiceDAO;
import com.solvd.deliveryservice.databasemodel.payment.Invoice;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MInvoiceDAO implements IInvoiceDAO {
    private static final Logger LOGGER = LogManager.getLogger(MInvoiceDAO.class);


    @Override
    public Invoice findById(int id) {
        Invoice invoice = null;
        SqlSession session = null;
        try{
            session = getSession();
            IInvoiceDAO mapper = session.getMapper(IInvoiceDAO.class);
            invoice = mapper.findById(id);
            session.commit();
            return invoice;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return invoice;
    }


    @Override
    public void insert(Invoice invoice) {
        SqlSession session = null;
        try{
            session = getSession();
            IInvoiceDAO mapper = session.getMapper(IInvoiceDAO.class);
            mapper.insert(invoice);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(Invoice invoice) {
        SqlSession session = null;
        try{
            session = getSession();
            IInvoiceDAO mapper = session.getMapper(IInvoiceDAO.class);
            mapper.update(invoice);
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
            IInvoiceDAO mapper = session.getMapper(IInvoiceDAO.class);
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

