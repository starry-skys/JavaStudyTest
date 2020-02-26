package com.thread.wait;

import java.util.ArrayList;
import java.util.List;

public class WaitTest {
    private static Object obj = new Object();

    public static void main(String[] args) {
        ListAdd listAdd = new ListAdd();

        Thread t1 = new Thread(() -> {
            synchronized (obj){
                try {
                    for (int i = 0; i < 10; i++) {
                        listAdd.add();
                        System.out.println("当前线程:"+Thread.currentThread().getName()+"添加了一个元素");
                        Thread.sleep(300);
                        if(listAdd.getSize() == 5){
                            System.out.println("发出通知");
                            obj.notify();
                        }
                    }
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (obj){
                try {
                    if(listAdd.getSize() != 5){
                        obj.wait();
                    }
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("线程:"+Thread.currentThread().getName()+"被通知.");
            }

        });

        t2.start();
        t1.start();
    }
}

class ListAdd {
    private static volatile List<String> list = new ArrayList<String>();

    public void add() {
        list.add("abc");
    }

    public int getSize() {
        return list.size();
    }
}