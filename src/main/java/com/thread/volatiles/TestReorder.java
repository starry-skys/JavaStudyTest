package com.thread.volatiles;

import java.util.concurrent.CountDownLatch;

/**
 * @author Stephen
 * @date 2020/5/27 15:25
 */
public class TestReorder {
    static int a,b,x,y;
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 1000000; i++){
            CountDownLatch latch = new CountDownLatch(2);
            new Thread(()->{
                a = 1;
                x = b;
                latch.countDown();
            }).start();
            new Thread(()->{
                b = 1;
                y = a;
                latch.countDown();
            }).start();
            latch.await();
            if(x == 0 && y == 0){
                System.out.println(x + "," + y);
            }else if(x == 1 && y == 1){
                System.out.println(x + "," + y);
            }
            x = y = a = b = 0;
        }
    }
}
