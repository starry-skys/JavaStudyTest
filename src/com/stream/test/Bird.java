package com.stream.test;

/**
 * @author Stephen
 * @date 2020/9/2 23:07
 */
public class Bird implements Animal {
    @Override
    public void eat() {
        System.out.println("早起的鸟儿有虫吃！");
    }
}
