package com.thread.lock;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 *
 * @DATE 2018/11/7 10:22
 */
public interface MyLock {
    void lock() throws InterruptedException;
    void lock(int mills) throws InterruptedException,TimeoutException;
    void unlock();
    List<Thread> getBlockedThreads();
}
