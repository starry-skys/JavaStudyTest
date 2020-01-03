package com.test.thread.test;

import java.util.concurrent.TimeUnit;

/**
 * @Author wanbei
 * @DATE 2018/10/25 16:17
 */
public class Test1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("first 5");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(7);
            System.out.println("sleep 5 seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("sleep error");
        }
//        thread.notify();

    }
}
