package com.proxy.cglib;

/**
 *
 * @DATE 2019/4/11 10:48
 */
public class TestCglib {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        CgTarget o = (CgTarget)cglibProxy.getCglibProxy(new CgTarget());
        o.getContent();
    }
}
