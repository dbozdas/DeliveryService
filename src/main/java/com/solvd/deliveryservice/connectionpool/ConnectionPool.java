package com.solvd.deliveryservice.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private final PoolConfig poolConfig;
    private int count;
    private BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(3);

    public ConnectionPool(PoolConfig poolConfig) {
        this.poolConfig = poolConfig;
        init();
    }

    public void init() {
        for (int i = 0; i < poolConfig.getInitConn(); i++) {
            Connection conn;
            try {
                conn = getNewConnection();
                pool.add(conn);
                count++;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized Connection getConnection() {
        Connection conn = null;
        try {
            if (count < poolConfig.getMaxActiveConn()) {
                if (pool.size() > 0) {
                    conn = pool.remove();
                } else {
                    conn = getNewConnection();
                    count++;
                }
                if (isEnable(conn)) {
                    pool.add(conn);
                } else {
                    count--;
                    conn = getConnection();
                }
            } else {
                wait(poolConfig.getWaitTime());
                conn = getConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    private boolean isEnable(Connection conn) {
        if (conn == null) {
            return false;
        }
        try {
            if (conn.isClosed()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    private Connection getNewConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(poolConfig.getUrl(), poolConfig.getUserName(), poolConfig.getPassword());
        return conn;
    }

    public synchronized void releaseConnection(Connection conn) {
        if (isEnable(conn)) {

            if (pool.size() < poolConfig.getMaxConn()) {
                pool.add(conn);
            } else {

                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        count--;

        notifyAll();


    }
}