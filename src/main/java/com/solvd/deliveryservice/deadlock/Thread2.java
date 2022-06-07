package com.solvd.deliveryservice.deadlock;

import com.solvd.deliveryservice.mybatis.MyBatis;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Thread2 extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(Thread2.class);
    DeadLockThread obj1, obj2;

    Thread2(DeadLockThread obj1, DeadLockThread obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void run() {
        synchronized (obj2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                LOGGER.error(ie);
            }
            obj1.display1(obj1);
        }
    }
}
