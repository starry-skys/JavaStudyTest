package com.test.designMode.single;

/**
 * @Author wanbei
 * @DATE 2019/7/31 11:02
 */
public class Singleton {

    private Singleton(){

    }

    //定义一个枚举类
    private enum SingletonEnum {
        //创建一个枚举实例
        INSTANCE;

        private Singleton singleton;

        //在枚举类的构造方法内实例化单例类
        SingletonEnum(){
            singleton = new Singleton();
        }

        private Singleton getInstance(){
            return singleton;
        }
    }

    public static Singleton getInstance(){
        //获取singleton实例
        return SingletonEnum.INSTANCE.getInstance();
    }
}
