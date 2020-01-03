package com.test.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author wanbei
 * @DATE 2018/11/1 11:05
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
//                e.printStackTrace();
            }
        });

        t.start();
        TimeUnit.MILLISECONDS.sleep(2);
        t.interrupt();
    }
}
