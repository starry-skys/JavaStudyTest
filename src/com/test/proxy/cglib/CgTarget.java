package com.test.proxy.cglib;

/**
 * @Author zwb
 * @DATE 2019/12/26 09:22
 */
public class CgTarget {
    public void getContent(){
        System.out.println("cglib被代理类getContent方法");
    }
}