package com.test.designMode.single;

/**
 * @Author wanbei
 * @DATE 2019/7/31 11:07
 */
public class TestSingleton {
    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i++) {
            new MyThread().start();
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.hashCode());
    }
}