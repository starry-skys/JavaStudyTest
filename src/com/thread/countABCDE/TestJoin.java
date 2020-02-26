package com.thread.countABCDE;

/**
 * @Author wanbei
 * @DATE 2019/4/25 15:38
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        JoinThread jt = new JoinThread();
        Thread t1 = new Thread(jt, "线程A");
        Thread t2 = new Thread(jt, "线程B");
        Thread t3 = new Thread(jt, "线程C");
        Thread t4 = new Thread(jt, "线程D");
        Thread t5 = new Thread(jt, "主线程");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        t5.start();
        t5.join();
    }
}
