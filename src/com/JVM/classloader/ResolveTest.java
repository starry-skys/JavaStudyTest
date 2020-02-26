package com.JVM.classloader;

public class ResolveTest {
    public static void main(String[] args) {
        System.out.println(Child.a);
    }

    interface Interface0 {
        int a = 0;
    }

    static class Parent {
        static int a = 1;
    }

    static class Child extends Parent implements Interface0 {
        static int a = 2;
    }
}
