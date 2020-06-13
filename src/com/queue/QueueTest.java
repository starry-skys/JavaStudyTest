package com.queue;

/**
 *
 * @DATE 2018/9/28 09:22
 * 队列
 */
public class QueueTest {
    public static void main(String[] args) {
        int[] q = new int[102];
        int[] arr = {0,6,3,1,7,5,8,9,2,4};
        System.arraycopy(arr,0,q,0,arr.length);
//        for (int i : q) {
//            System.out.printf(i+" ");
//        }

        int head = 1;
        int tail = 10;
        while (head<tail){
            //打印队首,并将队首出队
            System.out.print(q[head]+ " ");
            head ++;
            //将新队首的数添加至队尾
            q[tail] = q[head];
            tail ++;
            //再讲队首出队
            head ++;
        }


    }
}
