package com.thread.lock;

public class DeadLockTest {

//    public void method1(){
//        System.out.println(Thread.currentThread().getName() + "线程执行method1");
//    }
//
//    public void method2(){
//        System.out.println(Thread.currentThread().getName() + "线程执行method2");
//    }

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(()->{
            synchronized (lock1){
                System.out.println("A线程拿到了lock1锁");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A线程等待拿lock2锁");
                synchronized (lock2){
                    System.out.println("A线程拿到了lock2锁");
                }
            }
        });
        t1.setName("A");

        Thread t2 = new Thread(()->{
            synchronized (lock2){
                System.out.println("B线程拿到了lock2锁");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B线程等待拿lock1锁");
                synchronized (lock1){
                    System.out.println("B线程拿到了lock1锁");
                }
            }
        });
        t2.setName("B");

        t1.start();
        t2.start();
    }
}
