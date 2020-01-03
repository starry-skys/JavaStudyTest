package com.test.thread.callable;

import java.util.List;
import java.util.concurrent.*;

import static java.util.Arrays.asList;

/**
 * @Author wanbei
 * @DATE 2018/12/11 11:08
 */
public class Sums implements Callable<Long> {
    private long from;
    private final long to;

    public Sums(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        long acc = 0;
        for (long i = from; i <= to; i++) {
            acc = acc + i;
        }
        System.out.println(Thread.currentThread().getName() + ":" + acc);
        return acc;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Long>> results = executor.invokeAll(
                asList(new Sums(0, 10),new Sums(0,100),new Sums(0,1000)
        ));
        executor.shutdown();
        for (Future<Long> result : results) {
            System.out.println(result.get());
        }

    }
}
