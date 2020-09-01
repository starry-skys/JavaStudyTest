package com.stream;

/**
 * @author Stephen
 * @date 2020/5/1 14:31
 */
public class StreamTest {

    public static void main(String[] args) {
        //无限流
//        Stream.iterate(1, t -> t + 2).limit(10).forEach(System.out::println);
//
//        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        Predct predct = new Predct();
        predct.method3();
        predct.method2();

    }

    private static class Predct implements MyInterface,MyInterface2 {


        @Override
        public void method1() {
            System.out.println("child method1");
        }

        @Override
        public void method2() {
            System.out.println("child method2");
        }

        @Override
        public void method() {

        }
    }

    private interface MyInterface {
        public abstract void method1();
        default void method2(){
            System.out.println("interface method2");
        }
        default void method3(){
            System.out.println("interface method3");
        }
    }

    private interface MyInterface2 {
        public abstract void method();
        default void method2(){
            System.out.println("interface2 method2");
        }

    }
}
