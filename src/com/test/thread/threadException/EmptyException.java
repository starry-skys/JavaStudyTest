package com.test.thread.threadException;

import java.util.concurrent.TimeUnit;

/**
 * @Author wanbei
 * @DATE 2018/11/8 15:17
 */
public class EmptyException {
    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println(mainGroup.getName());
        System.out.println(mainGroup.getParent());
        System.out.println(mainGroup.getParent().getParent());

        final Thread thread = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {

            }
            System.out.println(1/0);
        },"Test-thread");


        thread.start();
    }
}
