package com.classLoad.order;

/**
 * @Author wanbei
 * @DATE 2018/11/13 11:03
 */
public class Child extends Parent {
    static {
        System.out.println("child init");
    }

    public static int x=10;
}
