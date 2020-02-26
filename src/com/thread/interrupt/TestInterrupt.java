package com.thread.interrupt;

import java.util.Random;

public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            private int count = 0;
            @Override
            public void run() {
                try {
//                    for (int i = 0; i < 5000; i++) {
//                        if(Thread.currentThread().isInterrupted()){
//                            System.out.println("中断循环");
//                            break;
//                        }
//                        count ++;
//                        System.out.println("count值："+count);
//                    }
                    if(Thread.currentThread().isInterrupted()){
                        throw new InterruptedException("被中断异常");
                    }
                    count = count + 1000;
                    count = count * count;
                    System.out.println(count);
//                    Thread.sleep(5000);
//                    System.out.println("睡眠结束");
                } catch (Exception e) {
                    System.out.println("异常:" + e);
                    System.out.println("打断标志："+Thread.currentThread().isInterrupted());
                } finally {
                    System.out.println("finally块被执行");
                }
            }
        });

        t.start();

//        Thread.sleep(1);
        t.interrupt();
        System.out.println("线程中断状态:"+t.isInterrupted());
    }
}
