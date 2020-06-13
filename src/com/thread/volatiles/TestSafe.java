package com.thread.volatiles;

/**
 *
 * @DATE 2019/5/17 09:28
 */
public class TestSafe {
    int result = 0;
    public synchronized int getResult(){
        return result;
    }
    public synchronized void setResult(int result){
        this.result = result;
    }
    public static void main(String[] args) {
        TestSafe testSafe = new TestSafe();
        for (int i = 0; i < 8; i++) {
            new Thread(()->{
                int x = 0;
                while(testSafe.getResult()<100){
                    x++;
                }
                System.out.println(Thread.currentThread().getName()+"线程的x值:"+x);
            }).start();

        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testSafe.setResult(200);
    }
}
