package com.solvd.deliveryservice.dao.mybatis;

import com.solvd.deliveryservice.dao.IMenuItemDAO;
import com.solvd.deliveryservice.databasemodel.order.MenuItem;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MMenuItemDAO implements IMenuItemDAO {
    private static final Logger LOGGER = LogManager.getLogger(MMenuItemDAO.class);


    @Override
    public MenuItem findById(int id) {
        MenuItem  menuItem = null;
        SqlSession session = null;
        try{
            session = getSession();
            IMenuItemDAO mapper = session.getMapper(IMenuItemDAO.class);
            menuItem = mapper.findById(id);
            session.commit();
            return menuItem;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return menuItem;
    }


    @Override
    public void insert(MenuItem menuItem) {
        SqlSession session = null;
        try{
            session = getSession();
            IMenuItemDAO mapper = session.getMapper(IMenuItemDAO.class);
            mapper.insert(menuItem);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(MenuItem menuItem) {
        SqlSession session = null;
        try{
            session = getSession();
            IMenuItemDAO mapper = session.getMapper(IMenuItemDAO.class);
            mapper.update(menuItem);
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
            IMenuItemDAO mapper = session.getMapper(IMenuItemDAO.class);
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

