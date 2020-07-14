package com.spi;

/**
 * @author Stephen
 * @date 2020/5/23 14:31
 */
public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("小猫吃鱼");
    }
}
