package com.thread.volatiles;

import java.util.concurrent.TimeUnit;

/**
 * @Author wanbei
 * @DATE 2018/11/14 17:32
 */
public class VolatileFoo {
    final static int MAX = 5;

    volatile static int init_value = 0;

    public static void main(String[] args) {
        new Thread(()->{
            int localValue = init_value;
            while(localValue < MAX){
                if(init_value!=localValue){
                    System.out.printf("The init_value is updated to %d\n",init_value);
                    localValue = init_value;
                }
            }
        },"reader").start();

        new Thread(()->{
            int localValue = init_value;
            while(localValue < MAX){
                System.out.printf("The init_value will be changed to %d\n",++localValue);
                init_value = localValue;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"updater").start();
    }

}
