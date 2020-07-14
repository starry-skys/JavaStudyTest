package com.JVM.classloader;

public class Child extends Parent {
    static {
        System.out.println("child init");
    }
}
