package com.thread.queue;

import java.util.concurrent.DelayQueue;

public class ProcessData {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayData> delayQueue = new DelayQueue<>();

        DelayData a = new DelayData(5, "A", 5000);
        DelayData b = new DelayData(8, "B", 8000);
        DelayData c = new DelayData(2, "C", 2000);

        delayQueue.add(a);
        delayQueue.add(b);
        delayQueue.add(c);

        System.out.println("开始计时时间:" + System.currentTimeMillis());
        for (int i = 0; i < 3; i++) {
            DelayData data = delayQueue.take();
            System.out.println("id:"+data.getId()+"，数据:"+data.getName()+"被移除，当前时间:"+System.currentTimeMillis());
        }
    }
}
