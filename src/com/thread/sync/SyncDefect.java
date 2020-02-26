package com.thread.sync;

import java.util.concurrent.TimeUnit;

/**
 * @Author wanbei
 * @DATE 2018/11/7 09:20
 */
public class SyncDefect{
    public synchronized void syncMethod(){
        try {
            System.out.println(Thread.currentThread().getName());
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncDefect defect = new SyncDefect();
        Thread t1 = new Thread(defect::syncMethod, "T1");
        t1.start();
        TimeUnit.MILLISECONDS.sleep(5);

        Thread t2 = new Thread(defect::syncMethod, "T2");
        t2.start();
        TimeUnit.MILLISECONDS.sleep(5);
        t2.interrupt();
        System.out.println(t2.isInterrupted());
        System.out.println(t2.getState());
        System.out.println(t1.isInterrupted());

    }
    
}
