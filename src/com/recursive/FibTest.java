package com.recursive;

/**
 *
 * @DATE 2019/8/13 14:15
 */
public class FibTest {


    public static long f(int n,long[] arr){
        if(n<=2){
            return n;
        }
        if(arr[n] != 0l){ //计算过arr[n]的值直接返回
            return arr[n];
        }else{
            return f(n-1,arr) + f(n-2,arr);
        }
    }

    public static void main(String[] args) {
        int n = 51;
        long[] arr = new long[n + 1];
        long start = System.currentTimeMillis();
        long res = f(n,arr);
        long time = System.currentTimeMillis() - start;
        System.out.println(res);
        System.out.println(time);
    }
}
