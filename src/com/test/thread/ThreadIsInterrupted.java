package com.test.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author wanbei
 * @DATE 2018/11/1 11:28
 */
public class ThreadIsInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("be interrupted :"+isInterrupted());
                    }
//                    System.out.println("be interrupted :"+Thread.interrupted());
                }
            }
        };
        t.setDaemon(true);
        t.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.println(t.isInterrupted());
        t.interrupt();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.println(t.isInterrupted());
    }
}
