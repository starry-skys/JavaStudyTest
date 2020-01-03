package com.test.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author wanbei
 * @DATE 2019/4/19 16:06
 */
public class RentrantLockTest {
   static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new ThreadDemo(i)).start();
        }

    }

    static class ThreadDemo implements Runnable{
        public Integer id;

        ThreadDemo(int id){
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 2; i++) {
                lock.lock();
                System.out.println("当前获得锁的线程:"+id);
                lock.unlock();
            }
        }
    }
}


