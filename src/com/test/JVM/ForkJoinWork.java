package com.test.JVM;

import java.util.concurrent.RecursiveTask;

public class ForkJoinWork extends RecursiveTask<Long> {

    private long start;
    private long end;

    //临界点
    private static final long THRESHOLD = 100_0000L;

    public ForkJoinWork(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long len = end - start;
        //不大于临界值直接计算结果
        if(len < THRESHOLD){
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else{
            //大于临界值时,拆分为两个子任务
            Long mid = (start + end) /2;
            ForkJoinWork task1 = new ForkJoinWork(start,mid);
            ForkJoinWork task2 = new ForkJoinWork(mid+1,end);
            task1.fork();
            task2.fork();
//            invokeAll(task1,task2);
            //合并计算
            return task1.join() + task2.join();
        }

    }
}
