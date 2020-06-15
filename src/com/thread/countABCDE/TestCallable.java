package com.thread.countABCDE;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @DATE 2019/4/25 16:14
 */
public class TestCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadCount tc = null;
        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorCompletionService<Integer> cs = new ExecutorCompletionService<>(es);
        for (int i = 0; i < 4; i++) {
            tc = new ThreadCount(i+1);
            cs.submit(tc);
        }
        es.shutdown();
        int total = 0;
        for (int i = 0; i < 4; i++) {
            total += cs.take().get();
        }

        System.out.println(total);
    }
}
