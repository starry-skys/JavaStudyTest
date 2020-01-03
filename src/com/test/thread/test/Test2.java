package com.test.thread.test;

import java.util.concurrent.TimeUnit;

/**
 * @Author wanbei
 * @DATE 2018/11/1 14:29
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
//        System.out.println(Thread.interrupted());

        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("still interrupted");
        }
        System.out.println(Thread.currentThread().isInterrupted());
    }
}
