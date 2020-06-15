package com.JVM.classloader;

public class ResolveTest2 {
    public static void main(String[] args) {
        Child child = new Child();
        child.method0();
    }

    interface Interface0 {
        void method0();
    }

    static class Parent {
        void method0(){
            System.out.println("parent method0");
        }
    }

    static class Child extends Parent{
        void method0(){
            System.out.println("child method0");
        }
    }

//    static abstract class Child implements Interface0 {
//
//    }

}
