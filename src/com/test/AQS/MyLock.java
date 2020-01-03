package com.test.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author wanbei
 * @DATE 2019/8/1 15:12
 */
public class MyLock implements Lock {

    Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    class Sync extends AbstractQueuedSynchronizer {
        //判断当前独占锁是否被占用
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override
        protected boolean tryAcquire(int arg) {
            //第一个线程进来拿到锁,返回true,第二个线程进来返回false,拿不到锁
            int state = getState();
            if(state == 0){
                if(compareAndSetState(0,arg)){
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(Thread.currentThread() != getExclusiveOwnerThread()){
                throw new RuntimeException();
            }
            int state = getState() - arg;
            setState(state);
            if(state ==0 ){
                setExclusiveOwnerThread(null);
                return true;
            }

            return false;
        }

        Condition newCondition(){
            return new ConditionObject();
        }
    }
}
