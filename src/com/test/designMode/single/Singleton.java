package com.test.designMode.single;

/**
 * @Author wanbei
 * @DATE 2019/7/31 11:02
 */
public class Singleton {
//    private static Singleton singleton = new Singleton();

    private Singleton(){

    }

    private static class Holder{
        private static Singleton instance = new Singleton();
    }

    public static Singleton getSingleton(){
        return Holder.instance;

    }
}
