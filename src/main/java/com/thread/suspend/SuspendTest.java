package com.thread.suspend;

public class SuspendTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Thread1());
        t.start();
        Thread.sleep(1000);
        t.suspend();
        System.out.println("main end");
        Thread.sleep(5000);
        t.resume();
    }
}

class Thread1 implements Runnable {

    private int count;

    @Override
    public void run() {
        while (true){
            count ++;
            System.out.println(count);
        }
    }

}