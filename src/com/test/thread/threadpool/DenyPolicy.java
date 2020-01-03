package com.test.thread.threadpool;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

/**
 * @Author wanbei
 * @DATE 2018/11/8 10:10
 */
public interface DenyPolicy {
    void reject(Runnable runnable, ThreadPool threadPool);
    class DiscardDenyPolicy implements DenyPolicy{

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {

        }

    }
}