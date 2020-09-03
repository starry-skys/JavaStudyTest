package com.stream.test;

/**
 * @author Stephen
 * @date 2020/9/2 23:46
 */
public class MyStaticInterfaceImpl implements MyStaticInterface {

    public static void main(String[] args) {
        //直接通过接口名调用静态方法，不能通过实现类的对象调用
        MyStaticInterface.method();
    }
}
