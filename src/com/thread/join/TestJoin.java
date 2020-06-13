package com.thread.join;

/**
 *
 * @DATE 2019/4/26 14:32
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MultiT("a"));
        Thread t2 = new Thread(new MultiT("b"));
        Thread t3 = new Thread(new MultiT("c"));

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();
    }

}

class MultiT implements Runnable{
    private String s;
    private int i;

    public MultiT(String s){
        this.s = s;
    }

    @Override
    public void run() {
        while(i<10){
            System.out.println(s+"===="+i++);
        }
    }
}
