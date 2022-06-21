package com.solvd.deliveryservice.dao.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class SessionPool {
    private static final Logger LOGGER = LogManager.getLogger(SessionPool.class);
    private static final String MYBATIS_URI = "mybatis/mybatisconfig.xml";
    private static SqlSessionFactory factory;
    private static Reader reader;
    private static SqlSession session;

    private SessionPool() {}


    public static SqlSession getSession() {
        try{
            reader = Resources.getResourceAsReader(MYBATIS_URI);
            factory = new SqlSessionFactoryBuilder().build(reader);
            session = factory.openSession();
            return session;
        } catch (IOException e){
            LOGGER.error(e.getMessage());
        } finally {
            close(reader);
        }
        return session;
    }


    public static void close(AutoCloseable resource){
        if(resource != null){
            try{
                resource.close();
            } catch (Exception e){
                LOGGER.error(e.getMessage());
            }
        }
    }
}

