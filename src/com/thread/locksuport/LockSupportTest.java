package com.thread.locksuport;

import java.sql.SQLOutput;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ParkThread());
        t.start();
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"开始唤醒阻塞线程");
//        t.interrupt();
        LockSupport.unpark(t);
        System.out.println(Thread.currentThread().getName()+"结束唤醒");

    }
}

class ParkThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始阻塞");
        LockSupport.park();
        System.out.println(Thread.currentThread().getName()+"第一次结束阻塞");
//        LockSupport.park();
//        System.out.println("第二次结束阻塞");
    }
}
