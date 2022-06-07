package com.solvd.deliveryservice.deadlock;

import com.solvd.deliveryservice.mybatis.MyBatis;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeadLockThread {
    private static final Logger LOGGER = LogManager.getLogger(DeadLockThread.class);
        void display1(DeadLockThread  obj2)
        {
            LOGGER.info("Thread1 waiting for thread2 to release lock");
            synchronized(obj2){
                LOGGER.info("Deadlock occurred");
            }
        }
        void display2(DeadLockThread  obj1)
        {
            LOGGER.info("Thread2 waiting for thread1 to release lock");
            synchronized(obj1){
                LOGGER.info("Deadlock occurred");
            }
        }
    }

class Deadlock {
        public static void main(String[] args)
        {
            DeadLockThread  obj1 = new DeadLockThread ();
            DeadLockThread  obj2 = new DeadLockThread ();

            Thread1 t1 = new Thread1(obj1, obj2);
            Thread2 t2 = new Thread2(obj1, obj2);
            t1.start();
            t2.start();
        }
    }
