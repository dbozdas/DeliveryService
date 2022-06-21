package com.solvd.deliveryservice.dao.mybatis;
import com.solvd.deliveryservice.dao.IStateDAO;
import com.solvd.deliveryservice.databasemodel.address.State;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.getSession;
import static com.solvd.deliveryservice.dao.mybatis.SessionPool.*;

public class MStateDAO implements IStateDAO {
    private static final Logger LOGGER = LogManager.getLogger(MStateDAO.class);


    @Override
    public State findById(int id) {
        State state = null;
        SqlSession session = null;
        try{
            session = getSession();
            IStateDAO mapper = session.getMapper(IStateDAO.class);
            state = mapper.findById(id);
            session.commit();
            return state;
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
        return state;
    }



    @Override
    public void insert(State state) {
        SqlSession session = null;
        try{
            session = getSession();
            IStateDAO mapper = session.getMapper(IStateDAO.class);
            mapper.insert(state);
            session.commit();
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null)
                close(session);
        }
    }

    @Override
    public void update(State state) {
        SqlSession session = null;
        try{
            session = getSession();
            IStateDAO mapper = session.getMapper(IStateDAO.class);
            mapper.update(state);
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
            IStateDAO mapper = session.getMapper(IStateDAO.class);
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
