package com.test.thread.threadException;

import java.util.concurrent.TimeUnit;

/**
 * @Author wanbei
 * @DATE 2018/11/8 15:00
 */
public class CaptureException {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t,e)->{
            System.out.println(t.getName()+ " occur exception");
            e.printStackTrace();
        });

        final Thread thread = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("interrupt exception");
            }
            System.out.println(1/0);
        },"Test-thread");
        thread.start();
    }


}
