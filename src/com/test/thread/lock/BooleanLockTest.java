package com.test.thread.lock;


import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author wanbei
 * @DATE 2018/11/7 10:50
 */
public class BooleanLockTest {
    private final MyLock lock = new BooleanLock();

    public void syncMethod(){
        try {
            lock.lock();
            int randomInt = ThreadLocalRandom.current().nextInt(10);
            System.out.println(Thread.currentThread().getName()+" get the lock,sleep "+randomInt+"s");
            TimeUnit.SECONDS.sleep(randomInt); //模拟业务所耗用时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void syncMethodTimeoutable(){
        try {
            lock.lock(1000);
            int randomInt = ThreadLocalRandom.current().nextInt(10);
            System.out.println(Thread.currentThread().getName()+" get the lock,sleep "+randomInt+"s");
            TimeUnit.SECONDS.sleep(randomInt); //模拟业务所耗用时间
        } catch (InterruptedException|TimeoutException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BooleanLockTest test = new BooleanLockTest();
//        IntStream.range(0,10).mapToObj(i -> new Thread(test::syncMethod)).forEach(Thread::start);
        Thread t1 = new Thread(test::syncMethod, "T1");
        t1.start();
        TimeUnit.MILLISECONDS.sleep(5);
        Thread t2 = new Thread(test::syncMethodTimeoutable, "T2");
        t2.start();

    }

}
