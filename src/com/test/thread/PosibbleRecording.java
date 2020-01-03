package com.test.thread;

/**
 * @Author wanbei
 * @DATE 2018/11/9 11:07
 */
public class PosibbleRecording {
    static int a,b = 0;
    static int x,y = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            a = 1;
            x = b;
        });

        Thread t2 = new Thread(() -> {
            b = 1;
            y = a;
        });
        t1.start();
        t2.start();
//        t1.join();
//        t2.join();
        System.out.println("x="+x+",y="+y);

    }
}
