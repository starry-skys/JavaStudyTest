package com.test.designPrinciple.isolation;

/**
 * @Author zwb
 * @DATE 2019/12/19 15:26
 */
public class Lion implements Animal,IRun {
    @Override
    public void eat() {
        System.out.println("狮子吃肉");
    }

    @Override
    public void run() {
        System.out.println("狮子奔跑");
    }
}