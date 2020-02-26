package com.thread.futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author wanbei
 * @DATE 2018/11/22 16:48
 * 模拟网购厨具的同时,购买食材,从而完成烹饪
 */
public class FutureCook {
    static class Chuju {

    }

    static class Shicai{

    }

    public static void cook(Chuju chuju,Shicai shicai){
        System.out.println("最后:烹饪中...");
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //第一步,网购厨具
        Callable<Chuju> shopping = new Callable<Chuju>(){

            @Override
            public Chuju call() throws Exception {
                System.out.println("第一步:下单");
                System.out.println("第一步:等待送货");
                Thread.sleep(5000); //模拟送货时间
                System.out.println("第一步:快递送到");
                return new Chuju();
            }
        };

        FutureTask<Chuju> task = new FutureTask<Chuju>(shopping);
        new Thread(task).start();

        //第二步,购买食材
        Thread.sleep(2000);
        Shicai shicai = new Shicai();
        System.out.println("第二步:食材到位");

        //第三步,烹饪
        if(!task.isDone()){ //是否厨具到位
            System.out.println("第三步:厨具还没到,请等待,也可以取消");
//            task.cancel(true);
//            System.out.println("已取消");
//            return;
        }

        //尝试获取结果，如果获取不到，就会进入等待状态
        // 即main线程等待子线程执行结束才能继续往下执行
        Chuju chuju = task.get();
        System.out.println("第三步:厨具到位,可以烹饪了");

        cook(chuju,shicai);

    }
}
