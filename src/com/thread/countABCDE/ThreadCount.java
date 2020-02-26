package com.thread.countABCDE;

import java.util.concurrent.Callable;

/**
 * @Author wanbei
 * @DATE 2019/4/25 16:12
 */
public class ThreadCount implements Callable<Integer> {
    private int type;

    public ThreadCount(int type) {
        this.type = type;
    }

    @Override
    public Integer call() throws Exception {
        if(type==1){
            System.out.println("C");
            return 1;
        }else if(type==2){
            Thread.sleep(2000);
            System.out.println("D");
            return 2;
        }else if(type==3){
            System.out.println("E");
            return 3;
        }else if(type==4){
            System.out.println("F");
            return 4;
        }
        return null;
    }
}
