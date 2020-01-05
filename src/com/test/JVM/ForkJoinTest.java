package com.test.JVM;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest {
    public static void main(String[] args) {

    }

    public static void testwork(){
        long l = System.currentTimeMillis();

        Long start = 0L;
        Long end = 1_0000_0000L;

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinWork work = new ForkJoinWork(start,end);
        Long invoke = forkJoinPool.invoke(work);

        long l1 = System.currentTimeMillis();
        System.out.println("结果:"+invoke+",耗时:"+(l1-l));

    }
}
