package com.test.JVM;

import java.util.concurrent.RecursiveTask;

public class ForkJoinWork extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    //临界点
    private static Long critical = 10000L;

    public ForkJoinWork(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long len = start - end;
        if(len < critical){
            Long sum = 0L;
            for (Long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        }else{
            //拆分为两个任务
            Long mid = start + end /2;
            ForkJoinWork work1 = new ForkJoinWork(start,mid);
            work1.fork(); //分支一
            ForkJoinWork work2 = new ForkJoinWork(start,mid);
            work2.fork(); //分支二

            //合并计算
            return work1.join() + work2.join();
        }

    }
}
