package com.thread.volatiles;

import java.util.concurrent.atomic.AtomicInteger;

public class TestVola {

    public static void main(String[] args) {
        int tc = 10;
        VolThread[] arr = new VolThread[tc];
        for (int i = 0; i < tc ; i++) {
            arr[i] =  new VolThread();
        }
        for (int i = 0; i < tc ; i++) {
            arr[i].start();
        }
    }
}


class VolThread extends Thread {
//    private static volatile int count = 0;
    private static AtomicInteger count = new AtomicInteger(0);
    @Override
    public void run() {

        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000 ; i++) {
//            count ++ ;
            count.incrementAndGet();
        }
        System.out.println("线程:"+Thread.currentThread().getName()+",count:" + count);
    }
}