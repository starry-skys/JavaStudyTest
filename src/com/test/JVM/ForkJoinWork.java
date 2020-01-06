package com.test.JVM;

import java.util.concurrent.RecursiveTask;

public class ForkJoinWork extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    //临界点
    private static final Long THRESHOLD = 10000L;

    public ForkJoinWork(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long len = end - start;
        if(len < THRESHOLD){
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            System.out.println("普通累加");
            return sum;
        }else{
            System.out.println("forkjoin累加");
            //拆分为两个任务
            Long mid = (start + end) /2;
            ForkJoinWork task1 = new ForkJoinWork(start,mid);
            ForkJoinWork task2 = new ForkJoinWork(mid+1,end);

            invokeAll(task1,task2);
            //合并计算
            return task1.join() + task2.join();
        }

    }
}
