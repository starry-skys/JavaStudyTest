package com.spi;

/**
 * @author Stephen
 * @date 2020/5/23 14:30
 */
public class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("小狗吃骨头");
    }
}
