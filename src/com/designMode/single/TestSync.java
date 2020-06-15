package com.designMode.single;

/**
 * @author Stephen
 * @date 2020/5/3 15:30
 */
public class TestSync {
    public static void main(String[] args) {
        SyncThread t = new SyncThread();
        t.start();
        Object lock = new Object();
        while(true){
            synchronized (lock){
                if(t.getFlag()){
                    System.out.println("come in ");
                    break;
                }
            }

        }
    }

    private static class SyncThread extends Thread {
        private boolean flag = false;
        public boolean getFlag(){
            return flag;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println(flag);
        }
    }
}
