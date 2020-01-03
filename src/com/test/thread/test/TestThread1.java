package com.test.thread.test;

/**
 * @Author wanbei
 * @DATE 2018/11/1 14:44
 */
public class TestThread1 {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.start();
        t1.interrupt();

        new Thread1().start();
    }
}
