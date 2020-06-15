package com.JVM.classloader;

public class Parent {
    public static int val = 1;
    static {
        System.out.println("parent init");
    }
}
