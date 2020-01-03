package com.test.thread.test;

/**
 * @Author zwb
 * @DATE 2019/12/12 11:45
 */
public class Test3 {
    static class Thread2 implements Runnable{

        private int num;
        @Override
        public void run() {
            num = 2;
            System.out.println("线程:"+ Thread.currentThread().getName()+",num:"+num);
            num = 5;
            System.out.println("线程:"+ Thread.currentThread().getName()+",num:"+num*3);
        }
    }

    public static void main(String[] args) {
        Thread2 t = new Thread2();
        for (int i = 0; i < 50; i++) {
            new Thread(t,"Thread-"+i).start();

        }
    }
}
