package com.solvd.deliveryservice.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class MyBatisInit {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisInit.class);
    private static SqlSessionFactory s;

    static {

        Reader r = null;

        try {
            r = Resources.getResourceAsReader("mybatis/mybatisconfig.xml");
            s = new SqlSessionFactoryBuilder().build(r);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static SqlSession getSession() {
        SqlSession SqlSession = s.openSession();
        return SqlSession;
    }

}

