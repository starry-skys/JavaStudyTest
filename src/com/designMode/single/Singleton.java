package com.designMode.single;

import java.io.Serializable;

/**
 *
 * @DATE 2019/7/31 11:02
 */
public class Singleton implements Serializable {

    //注意，此变量需要用volatile修饰以防止指令重排序
    private static volatile Singleton singleton = null;

    private Singleton(){
        if(singleton != null){
            throw new RuntimeException("Can not do this");
        }
    }

    public static Singleton getInstance(){
        //进入方法内，先判断实例是否为空，以确定是否需要进入同步代码块
        if(singleton == null){
            synchronized (Singleton.class){
                //进入同步代码块时再次判断实例是否为空
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    private Object readResolve(){
        return singleton;
    }
}
