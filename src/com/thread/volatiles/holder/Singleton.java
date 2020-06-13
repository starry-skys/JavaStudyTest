package com.thread.volatiles.holder;

/**
 *
 * @DATE 2018/11/15 17:19
 */
public final class Singleton {
    private byte[] data = new byte[1024]; //实例变量

    private Singleton(){

    }

    private static class Holder{
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance(){
        return  Holder.singleton;
    }
}
