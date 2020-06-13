package com.designPrinciple.isolation;

/**
 * @Author Stephen
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
