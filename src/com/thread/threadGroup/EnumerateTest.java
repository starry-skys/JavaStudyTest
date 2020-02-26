package com.thread.threadGroup;

/**
 * @Author wanbei
 * @DATE 2018/11/7 16:46
 */
public class EnumerateTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup myGroup1 = new ThreadGroup("myGroup1");
        ThreadGroup myGroup2 = new ThreadGroup(myGroup1, "myGroup2");

        Thread.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup[] list = new ThreadGroup[mainGroup.activeGroupCount()];
        int size1 = mainGroup.enumerate(list);
        System.out.println(size1);

        int size2 = mainGroup.enumerate(list, false);
        System.out.println(size2);


    }
}
