package com.test.JVM;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class ForkJoinTest {
    public static void main(String[] args) throws Exception{
        Long start = 0L;
        Long end = 10_0000_0000L;

        testForkJoin(start,end);
    }

    public static void testSum(Long start,Long end){
        long l = System.currentTimeMillis();

        Long sum = 0L;
        for (Long i = start; i <= end ; i++) {
            sum += i;
        }

        long l1 = System.currentTimeMillis();
        System.out.println("结果:"+sum+",耗时:"+(l1-l));
    }

    public static void testForkJoin(Long start,Long end) throws Exception{
        long l = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinWork task = new ForkJoinWork(start,end);
        Long invoke = forkJoinPool.invoke(task);

        long l1 = System.currentTimeMillis();
        System.out.println("结果:"+invoke+",耗时:"+(l1-l));
    }

    public static void testStream(Long start,Long end){
        long l = System.currentTimeMillis();

        long reduce = LongStream.rangeClosed(start, end).parallel().reduce(0, (x, y) -> x + y);

        long l1 = System.currentTimeMillis();
        System.out.println("结果:"+reduce+",耗时:"+(l1-l));
    }
}