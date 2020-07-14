package com.JVM;

/**
 * @author Stephen
 * @date 2020/7/13 20:19
 */
public class FinalizeTest {
    public static FinalizeTest finalizer = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method invoked");
        finalizer = this;
    }

    public static void main(String[] args) throws InterruptedException {
        finalizer = new FinalizeTest();

        //第一次gc，会先触发finalize方法
        finalizer = null;
        //这里为了看效果，需要显式的调用一下gc，因为你不知道它何时会触发gc
        System.gc();
        //这里为了看效果，需要停顿一会儿，因为finalize方法的优先级比较低，有可能此时还未执行到
        Thread.sleep(500);
        if(finalizer != null){
            System.out.println("still alive");
        }else{
            System.out.println("is dead");
        }

        //第二次gc，由于已经触发过finalize方法，此方法只会被系统调用一次，因此对象死亡
        finalizer = null;
        System.gc();
        Thread.sleep(500);
        if(finalizer != null){
            System.out.println("still alive");
        }else{
            System.out.println("is dead");
        }
    }
}
