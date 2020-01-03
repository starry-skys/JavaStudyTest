package com.test.designPrinciple.demeter;

/**
 * @Author zwb
 * @DATE 2019/12/19 16:30
 */
public class Computer {

    public void executeCmd(){
        System.out.println("执行程序");
    }

    public void loadMemory(){
        System.out.println("加载内存数据");
    }

    public void graphics(){
        System.out.println("显卡驱动");
    }

    public void sounds(){
        System.out.println("声卡驱动");
    }
}
