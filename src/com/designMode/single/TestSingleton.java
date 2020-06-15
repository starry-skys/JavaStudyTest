package com.designMode.single;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * @DATE 2019/7/31 11:07
 */
public class TestSingleton {
    public static void main(String[] args) {
        int n = 1000;
        CyclicBarrier barrier = new CyclicBarrier(n);
        for (int i = 0; i < n ; i++) {
            new MyThread(barrier).start();
        }

    }
}

class MyThread extends Thread {

    CyclicBarrier barrier;
    public MyThread (CyclicBarrier barrier){
        this.barrier = barrier;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(10);
            barrier.await();
            Singleton singleton = Singleton.getInstance();
//            System.out.println(singleton.hashCode());
            System.out.println(singleton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}