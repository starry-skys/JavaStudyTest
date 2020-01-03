package com.test.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author wanbei
 * @DATE 2018/10/25 10:33
 */
public class TryConcurrency {
    public static void main(String[] args) {
//        new Thread(){
//            @Override
//            public void run() {
//                browseNews();
//            }
//        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                browseNews();
            }
        }).start();

        listenMusic();
    }

    private static void browseNews(){
        for (;;){
            System.out.println("看新闻");
            sleep(1);
        }
    }

    private static void listenMusic(){
        for (;;){
            System.out.println("听音乐");
            sleep(1);
        }
    }

    private static void sleep(int n){
        try {
            TimeUnit.SECONDS.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
