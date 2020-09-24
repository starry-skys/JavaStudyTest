package com.designMode.single;

import java.io.Serializable;

/**
 * @author Stephen
 * @date 2020/9/24 21:39
 */
public class Singleton1 implements Serializable {
    private Singleton1(){

    }

    private enum SingletonEnum {
        INSTANCE;
        private Singleton1 singleton;
        SingletonEnum() {
            singleton = new Singleton1();
        }
        private Singleton1 getInstance(){
            return singleton;
        }
    }

    public static Singleton1 getInstance(){
        return SingletonEnum.INSTANCE.getInstance();
    }
}
