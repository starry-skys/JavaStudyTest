package com.thread.countABCDE;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @Author wanbei
 * @DATE 2019/4/25 16:36
 */
public class CountDownLatchDemo {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Worker w1 = new Worker("zs", 2000, latch);
        Worker w2 = new Worker("ls", 3000, latch);
        w1.start();
        w2.start();

        latch.await();
        System.out.println("all work done at "+ sdf.format(new Date()));

    }

    static class Worker extends Thread{
        String name;
        int workTime;
        CountDownLatch latch;

        public Worker(String name, int workTime, CountDownLatch latch) {
            this.name = name;
            this.workTime = workTime;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println(name+" start at "+sdf.format(new Date()));
            doWork();
            System.out.println(name+" end at "+sdf.format(new Date()));
            latch.countDown();
        }

        private void doWork() {
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
