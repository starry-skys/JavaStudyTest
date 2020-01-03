package com.test.AQS;

import java.util.concurrent.locks.Lock;

/**
 * @Author wanbei
 * @DATE 2019/8/1 15:30
 */
public class MyLockTest {
    private Lock lock = new MyLock();
    private int value;

    public int getNext(){
        lock.lock();
        value ++;
        lock.unlock();
        return value;
    }

    public static void main(String[] args) {
        MyLockTest s = new MyLockTest();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(s.getNext());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
