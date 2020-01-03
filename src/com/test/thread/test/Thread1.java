package com.test.thread.test;

public class Thread1 extends Thread{
	public void run() {
        try {
            while (true){
                Thread.sleep(2000);//阻塞状态，线程被调用了interrupte（）方法，清除中断标志，抛出InterruptedException
                //dosomething
                
                boolean isIn = this.isInterrupted();
                System.out.println("中断值："+isIn);
                //运行状态，线程被调用了interrupte（）方法，中断标志被设置为true
                //非阻塞状态中进行中断线程操作
                if(isInterrupted()) break;//退出循环，中断进程
            }
        }catch (InterruptedException e){//阻塞状态中进行中断线程操作
            boolean isIn = this.isInterrupted();//退出阻塞状态，且中断标志被清除，重新设置为false，所以此处的isIn为false
            System.out.println("catch中断值："+isIn);
            e.printStackTrace();
            return;//退出run方法，中断进程
        }
    }
}
