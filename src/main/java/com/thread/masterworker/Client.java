package com.thread.masterworker;

import java.util.Random;

public class Client {
    public static void main(String[] args) {

        Master master = new Master(new MyWorker(), 10);

        //提交n个任务到任务队列里
        for (int i = 0; i < 100; i++) {
            Task task = new Task();
            task.setId(i);
            task.setName("任务"+i);
            task.setNum(i+1);
            master.submit(task);
        }

        //执行任务
        long start = System.currentTimeMillis();
        int res = master.execute();
        long time = System.currentTimeMillis() - start;
        System.out.println("结果:"+res+",耗时:"+time);
    }
}
