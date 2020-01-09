package com.test.JVM;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class ForkJoinTest {
    public static void main(String[] args) throws Exception{
        long start = 0L;
        long end = 20_0000_0000L;

        testSum(start,end);
        testForkJoin(start,end);
        testStream(start,end);

    }

    /**
     * 普通for循环 - 7155ms
     * @param start
     * @param end
     */
    public static void testSum(Long start,Long end){
        long l = System.currentTimeMillis();

        long sum = 0L;
        for (long i = start; i <= end ; i++) {
            sum += i;
        }

        long l1 = System.currentTimeMillis();
        System.out.println("普通for循环结果:"+sum+",耗时:"+(l1-l));
    }

    /**
     * forkjoin方式 - 6700ms
     * @param start
     * @param end
     * @throws Exception
     */
    public static void testForkJoin(long start,long end) throws Exception{
        long l = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinWork task = new ForkJoinWork(start,end);
        long invoke = forkJoinPool.invoke(task);

        long l1 = System.currentTimeMillis();
        System.out.println("forkjoin结果:"+invoke+",耗时:"+(l1-l));
    }

    /**
     * stream流 - 544
     * @param start
     * @param end
     */
    public static void testStream(Long start,Long end){
        long l = System.currentTimeMillis();

        long reduce = LongStream.rangeClosed(start, end).parallel().reduce(0, (x, y) -> x + y);

        long l1 = System.currentTimeMillis();
        System.out.println("stream流结果:"+reduce+",耗时:"+(l1-l));
    }
}
