package com.stream;

/**
 * @Author zwb
 * @DATE 2020/9/2 16:25
 */
@FunctionalInterface
public interface MyFunc {
    void method1();
    default void method2(){
        System.out.println("haha");
    }
    static void method3(){
        System.out.println("method3");
    }
}
