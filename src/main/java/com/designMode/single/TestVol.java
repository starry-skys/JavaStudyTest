package com.designMode.single;

import java.util.concurrent.CountDownLatch;

/**
 * @author Stephen
 * @date 2020/5/3 11:09
 */
public class TestVol {
    private static volatile int count = 0;
    public static void main(String[] args) throws InterruptedException {
        int n = 100;
        CountDownLatch countDownLatch = new CountDownLatch(n);
        for (int i = 0; i < n; i++) {
            new AtoThread(countDownLatch).start();
        }
        countDownLatch.await();
        System.out.println(count);
    }

    private static class AtoThread extends Thread {

        private CountDownLatch latch;
        public AtoThread (CountDownLatch latch){
            this.latch = latch;
        }
        @Override
        public void run() {
            synchronized (latch){
                for (int i = 0; i < 1000; i++) {
                    count ++;
                }
            }

            latch.countDown();
        }

    }
}
