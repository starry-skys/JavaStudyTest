package com.AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author wanbei
 * @DATE 2019/8/1 14:27
 */
public class SimpleLock extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        if(compareAndSetState(0,1)){
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    public void lock(){
        acquire(1);
    }

    public void tryLock(){
        tryAcquire(1);
    }

    public void unlock(){
        release(1);
    }

    /**
     * 发现线程是顺序获得锁的
     * 因为AQS是基于CLH锁的一个变种实现的FIFO调度
     */
    public static void main(String[] args) throws InterruptedException {
        SimpleLock lock = new SimpleLock();
        lock.lock();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    System.out.println(Thread.currentThread().getId()+" acquired the lock");
                    lock.unlock();
                }
            }).start();
            // 简单的让线程按照for循环的顺序阻塞在lock上
            //目的是让线程顺序启动
            Thread.sleep(100);
        }

        System.out.println("main thread unlock");
        lock.unlock();
    }

}
