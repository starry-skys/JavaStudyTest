package com.test.classLoad.order;

/**
 * @Author wanbei
 * @DATE 2018/11/12 17:31
 */
public class Code {
    {
        System.out.println("code的构造代码块");
    }

    static {
        System.out.println("code的静态代码块");
    }

    public Code() {
        System.out.println("code的构造方法");
    }
}
