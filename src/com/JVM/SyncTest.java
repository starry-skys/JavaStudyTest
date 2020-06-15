package com.JVM;


/**
 * @author Stephen
 * @date 2020/5/18 10:03
 */
public class SyncTest {
    int count = 0;
    public  void method1(){
        synchronized (this){
            count++;
        }
    }

    public static void main(String[] args) throws Exception{
//        SyncTest synCls = new SyncTest();
//        Thread t1 = new Thread(()->{
//            for (int i = 0; i < 1000000; i++) {
//                synCls.method1();
//            }
//        });
//        Thread t2 = new Thread(()->{
//            for (int i = 0; i < 1000000; i++) {
//                synCls.method1();
//            }
//        });
//        t1.start();
//        t2.start();
//        t1.join();t2.join();
//        System.out.println(synCls.count);


    }


}
