package com.JVM.classloader;

public class TestClassLoader {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(obj.getClass().getClassLoader());

        TestClassLoader t = new TestClassLoader();
        System.out.println(t.getClass().getClassLoader());
        System.out.println(t.getClass().getClassLoader().getParent());
        System.out.println(t.getClass().getClassLoader().getParent().getParent());
    }
}
