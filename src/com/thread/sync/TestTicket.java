package com.thread.sync;

class TicketThread implements Runnable {

    private int count;

    public TicketThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(20);
            } catch (Exception e) {

            }
            synchronized (this){
                if(count>0){
                    System.out.println("线程" + Thread.currentThread().getName() + "余票：" + count + "张");
                    count--;
                }
            }
        }
    }
}

public class TestTicket {
    public static void main(String[] args) throws InterruptedException {
        TicketThread ticketThread = new TicketThread(100);
        Thread t1 = new Thread(ticketThread, "t1");
        Thread t2 = new Thread(ticketThread, "t2");
        t1.start();
        t2.start();
    }
}


