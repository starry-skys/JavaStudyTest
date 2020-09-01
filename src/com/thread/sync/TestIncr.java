package com.thread.sync;

/**
 * @author Stephen
 * @date 2020/5/2 17:50
 */
public class TestIncr {


    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();t2.start();
        t1.join();t2.join();

        System.out.println(t.getCount());
    }

    private static class MyThread implements Runnable{

        private static int count = 0;
        public int getCount(){
            return count;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                synchronized (MyThread.class){
                    count ++;
                }
            }
        }
    }

}
