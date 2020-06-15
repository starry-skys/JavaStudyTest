package com.thread.interrupt;

import java.util.Random;

public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            private int count = 0;
            @Override
            public void run() {
                try {
                    count = new Random().nextInt(1000);
                    count = count * count;
                    System.out.println("count:"+count);
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName()+"线程第一次中断标志："+Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName()+"线程第二次中断标志："+Thread.currentThread().isInterrupted());
                }
            }
        });

        t.start();

        Thread.sleep(100);
        t.interrupt();
    }
}
