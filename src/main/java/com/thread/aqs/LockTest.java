package com.thread.aqs;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(()->{
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            });
            t.start();
        }
    }
}
