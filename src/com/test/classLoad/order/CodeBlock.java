package com.test.classLoad.order;

/**
 * @Author wanbei
 * @DATE 2018/11/12 17:33
 */
public class CodeBlock {
    {
        System.out.println("CodeBlock的构造代码块");
    }

    static {
        System.out.println("CodeBlock的静态代码块");
    }

    public CodeBlock() {
        System.out.println("CodeBlock的构造方法");
    }

    public static void main(String[] args){
        System.out.println("CodeBlock的主方法");
        new Code();
        new Code();
        new CodeBlock();
        new CodeBlock();
    }

}
