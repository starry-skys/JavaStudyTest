package com.thread.countABCDE;

/**
 * @Author wanbei
 * @DATE 2019/4/25 15:40
 */
public class JoinThread implements Runnable {
    @Override
    public void run() {
        System.out.println("name:"+Thread.currentThread().getName());
    }
}
