package com.solvd.deliveryservice.connectionpool;

import com.solvd.deliveryservice.dao.implDAO.addressDAO.AddressDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DataSourceUtils {
    private static final Logger LOGGER = LogManager.getLogger(DataSourceUtils.class);
    private static final PoolConfig poolConfig = new PoolConfig();

    static{
        Properties prop = new Properties();
        try {
            prop.load(DataSourceUtils.class.getClassLoader()
                    .getResourceAsStream("db.properties"));
            poolConfig.setDriverName(prop.getProperty("jdbc.driverName"));
            poolConfig.setUrl(prop.getProperty("jdbc.url"));
            poolConfig.setUserName(prop.getProperty("jdbc.userName"));
            poolConfig.setPassword(prop.getProperty("jdbc.password"));

            Class.forName(poolConfig.getDriverName());
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
    }
    private static final ConnectionPool connPool = new ConnectionPool(poolConfig);

    public static Connection getConnection(){
        return connPool.getConnection();
    }

    public static void closeConnection(Connection conn){
        connPool.releaseConnection(conn);
    }
}
