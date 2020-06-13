package com.thread.executor;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @DATE 2019/5/7 17:20
 */
public class ScheduledTest {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);

        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟5秒后,每3秒执行一次");
            }
        },5,3, TimeUnit.SECONDS);
    }
}
