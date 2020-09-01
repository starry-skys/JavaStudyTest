package com.thread.lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import static java.lang.System.currentTimeMillis;

/**
 *
 * @DATE 2018/11/7 10:31
 */
public class BooleanLock extends Thread implements MyLock {
    private Thread currentThread; //当前拥有锁的线程
    private boolean locked = false; //true代表已经被某个线程获得锁,该线程就是currentThread
    private final List<Thread> blockedList = new ArrayList<>(); //被阻塞的线程

    @Override
    public void lock() throws InterruptedException {
        synchronized (this){
            final Thread temp = currentThread();
            try {
                while (locked){
                    blockedList.add(currentThread());
                    this.wait();
                }
            } catch (InterruptedException e) {
                //如果当前线程在wait时被中断,则从list中删除
                blockedList.remove(temp);
                throw e;
            }
            blockedList.remove(currentThread());
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    @Override
    public void lock(int mills) throws InterruptedException, TimeoutException {
        synchronized (this){
            if(mills <=0){
                lock();
            }else{
                long remain = mills;
                long end = currentTimeMillis() + remain;
                while(locked){
                    if(remain <= 0){
                        throw new TimeoutException("can't not get the lock during "+mills);
                    }
                    if(!blockedList.contains(currentThread())){
                        blockedList.add(currentThread());
                    }
                    this.wait(remain);
                    remain = end - currentTimeMillis();
                }
                blockedList.remove(currentThread());
                this.locked = true;
                this.currentThread = currentThread();
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (this){
            if(currentThread == currentThread()){
                this.locked = false;
                Optional.of(currentThread().getName() + " release the lock").ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}
