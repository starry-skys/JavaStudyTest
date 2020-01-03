package com.test.classLoad;

/**
 * @Author wanbei
 * @DATE 2018/11/14 15:56
 */
public class ThreadContext {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
