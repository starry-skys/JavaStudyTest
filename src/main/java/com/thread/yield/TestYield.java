package com.thread.yield;

public class TestYield {
    public static void main(String[] args) {
        YieldThread yieldThread = new YieldThread();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(yieldThread);
            t.start();
        }
    }
}

class YieldThread implements Runnable {

    private int count = 0;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            count ++;
            if(count == 1){
                Thread.yield();
                System.out.println("线程:"+Thread.currentThread().getName() + "让步");
            }
            System.out.println("线程:"+Thread.currentThread().getName() + ",count:"+count);
        }
    }
}