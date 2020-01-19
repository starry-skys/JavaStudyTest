package com.test.designMode.single;

/**
 * @Author wanbei
 * @DATE 2019/7/31 11:02
 */
public class Singleton {

    private static volatile Singleton singleton = null;

    private Singleton(){

    }

    public static Singleton getInstance(){
        //进入方法内，先判断实例是否为空，以确定是否需要进入同步代码块
        if(singleton == null){
            synchronized (Singleton.class){
                //进入同步代码块时也需要判断实例是否为空
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
