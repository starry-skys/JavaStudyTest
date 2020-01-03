package com.test.thread;

/**
 * @Author wanbei
 * @DATE 2018/11/1 10:31
 */
public class CurrentThread {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread() == this);
            }
        };
        t.start();

        String name = Thread.currentThread().getName();
        System.out.println("main".equals(name));
    }
}
