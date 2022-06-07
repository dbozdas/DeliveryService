package com.solvd.deliveryservice.connectionpool;

public class PoolConfig{

    private String driverName;
    private String url;
    private String userName;
    private String password;

    private int minConn=1;
    private int maxConn=5;
    private int initConn=5;

    private int maxActiveConn = 3;
    private int waitTime = 1000;
    private boolean isCheck = false;
    private long checkPeriod = 1000*30;


    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getMinConn() {
        return minConn;
    }
    public void setMinConn(int minConn) {
        this.minConn = minConn;
    }
    public int getMaxConn() {
        return maxConn;
    }
    public void setMaxConn(int maxConn) {
        this.maxConn = maxConn;
    }
    public int getInitConn() {
        return initConn;
    }
    public void setInitConn(int initConn) {
        this.initConn = initConn;
    }
    public int getMaxActiveConn() {
        return maxActiveConn;
    }
    public void setMaxActiveConn(int maxActiveConn) {
        this.maxActiveConn = maxActiveConn;
    }
    public int getWaitTime() {
        return waitTime;
    }
    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
    public boolean isCheck() {
        return isCheck;
    }
    public void setCheck(boolean check) {
        isCheck = check;
    }
    public long getCheckPeriod() {
        return checkPeriod;
    }
    public void setCheckPeriod(long checkPeriod) {
        this.checkPeriod = checkPeriod;
    }
}
