package com.classLoad;

/**
 *
 * @DATE 2018/11/13 11:20
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    private static int x=0;
    private static int y;



    private Singleton(){
        x++;
        y++;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }
}
