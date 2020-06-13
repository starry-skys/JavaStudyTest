package com.thread.countABCDE;

import java.util.concurrent.CountDownLatch;

/**
 * 保证线程的执行顺序——CountDownLatch实现方式
 */
public class TestABC {
    public static void main(String[] args) {
        CountDownLatch c1 = new CountDownLatch(0);
        CountDownLatch c2 = new CountDownLatch(1);
        CountDownLatch c3 = new CountDownLatch(1);

        Thread t1 = new Thread(new Worker(c1, c2));
        Thread t2 = new Thread(new Worker(c2, c3));
        Thread t3 = new Thread(new Worker(c3, c3));

        t1.start();
        t2.start();
        t3.start();
    }

    static class Worker implements Runnable{

        private CountDownLatch c1 ,c2;

        public Worker(CountDownLatch c1, CountDownLatch c2){
            this.c1 = c1;
            this.c2 = c2;
        }

        @Override
        public void run() {
            try {
                //只要countdownlatch为0，才会执行
                c1.await();
                System.out.println(Thread.currentThread().getName()+"线程开始执行");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"线程执行结束");
                //然后把第二个countdownlatch减一
                c2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
