package com.stream.test;

/**
 * @author Stephen
 * @date 2020/9/2 23:05
 */
public interface Animal {
    //所有动物都需要吃东西，具体吃什么，让子类去实现
    void eat();

    default void run(){
        System.out.println("我跑");
    }

    default void fly(){
        System.out.println("我飞");
    }

    static void show(){
        System.out.println("");
    }
}
