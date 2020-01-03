package com.test.sync;

/**
 * Created by wanbei on 2018/1/23 16:06.
 */
public class Ticket implements Runnable {

    private int num;//票数量
    private boolean flag=true;//若为false则售票停止
    public Ticket(int num){
        this.num=num;
    }
    @Override
    public void run() {
        while(flag){
            ticket();
        }
    }
    private synchronized void ticket(){
        if(num<=0){
            flag=false;
            return;
        }
        try {
            Thread.sleep(200);//模拟延时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //输出当前窗口号以及出票序列号
        System.out.println(Thread.currentThread().getName()+"售出票序列号："+num--);
    }
}
class MainTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket(5);
        Thread window01 = new Thread(ticket, "窗口01");
        Thread window02 = new Thread(ticket, "窗口02");
        Thread window03 = new Thread(ticket, "窗口03");
        window01.start();
        window02.start();
        window03.start();
    }
}
