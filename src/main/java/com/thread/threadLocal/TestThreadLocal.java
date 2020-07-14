package com.thread.threadLocal;

public class TestThreadLocal {
    public static void main(String[] args) {
        Res res = new Res();
        LocalThread t1 = new LocalThread(res);
        LocalThread t2 = new LocalThread(res);
        LocalThread t3 = new LocalThread(res);
        t1.start();
        t2.start();
        t3.start();
    }
}

class LocalThread extends Thread {
    private Res res;
    public LocalThread (Res res){
        this.res = res;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(getName() + ":" + res.getNum());
        }

    }
}

class Res {
    private ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public Integer getNum (){
        int c = this.count.get() + 1;
        this.count.set(c);
        return c;
    }
}