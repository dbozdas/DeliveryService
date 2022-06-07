package com.solvd.deliveryservice.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Thread1 extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(Thread1.class);
    DeadLockThread obj1, obj2;

    Thread1(DeadLockThread obj1, DeadLockThread obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void run() {
        synchronized (obj1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                LOGGER.error(ie);
            }
            obj2.display2(obj2);
        }
    }
}
