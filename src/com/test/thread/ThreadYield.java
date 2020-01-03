package com.test.thread;

import java.util.stream.IntStream;

/**
 * @Author wanbei
 * @DATE 2018/10/31 17:06
 */
public class ThreadYield {
    public static void main(String[] args) {
        IntStream.range(0,3).mapToObj(ThreadYield::create).forEach(Thread::start);

    }

    private static Thread create(int i) {
        return new Thread(() ->{
           if(i==0)
               Thread.yield();
            System.out.println(i);
        });
    }
}
