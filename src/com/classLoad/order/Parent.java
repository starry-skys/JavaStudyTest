package com.classLoad.order;

/**
 * @Author wanbei
 * @DATE 2018/11/13 11:02
 */
public class Parent {
    static {
        System.out.println("parent init");
    }
    public static int y=100;
}
