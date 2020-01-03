package com.test.thread.sync;

import java.util.concurrent.TimeUnit;

/**
 * @Author wanbei
 * @DATE 2018/11/5 15:40
 */
public class ThisMonitor extends Thread{
    public synchronized void method1(){
        System.out.println(currentThread().getName() + " enter method1");
        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2(){
        System.out.println(currentThread().getName() + " enter method2");
        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThisMonitor thisMonitor = new ThisMonitor();
        new Thread(thisMonitor::method1,"T1").start();
        new Thread(thisMonitor::method2,"T2").start();

    }
}
