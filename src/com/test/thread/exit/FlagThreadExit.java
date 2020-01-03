package com.test.thread.exit;

import java.util.concurrent.TimeUnit;

/**
 * @Author wanbei
 * @DATE 2018/11/2 15:26
 */
public class FlagThreadExit {
    static class MyTask extends Thread{
        private volatile boolean closed = false;

        @Override
        public void run() {
            System.out.println("start");
            while(!closed && !isInterrupted()){
//                System.out.println("running...");
            }
            System.out.println("existing");
        }

        public void close(){
            this.closed = true;
            this.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask t = new MyTask();
        t.start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("will shutdown");
        t.close();
    }
}
