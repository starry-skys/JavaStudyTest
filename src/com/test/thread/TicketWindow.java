package com.test.thread;

/**
 * @Author wanbei
 * @DATE 2018/10/25 17:11
 */
public class TicketWindow implements Runnable {
    private static int i = 1;
    private static final Object obj = new Object();
    @Override
    public void run() {
        synchronized (obj){
            while (i<=50){
                System.out.println(Thread.currentThread().getName()+ "号窗口的号码是:" + i++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        TicketWindow task = new TicketWindow();
        Thread thread1 = new Thread(task, "一");
        Thread thread2 = new Thread(task, "二");
        Thread thread3 = new Thread(task, "三");
        Thread thread4 = new Thread(task, "四");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
