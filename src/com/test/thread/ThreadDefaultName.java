package com.test.thread;

import java.util.stream.IntStream;

/**
 * @Author wanbei
 * @DATE 2018/10/25 17:32
 */
public class ThreadDefaultName {
    public static void main(String[] args) {
        IntStream.range(0,5).boxed().map(i -> new Thread(()->System.out.println(Thread.currentThread().getName())))
                .forEach(Thread::start);
    }
}
