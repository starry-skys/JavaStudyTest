package com.sort.bucket;

import java.util.Random;

/**
 *
 * @DATE 2018/9/26 17:01
 */
public class Test1 {
    public static void main(String[] args) {
        int n = 11;
        int[] arr = new int[n]; //代表数值的范围为0~1000
        Random random = new Random();

        int length = n-1; //代表有几个数
        int[] sortArr = new int[length];
        System.out.println("排序前为:");
        for (int i = 0; i < length; i++) {
            int t = random.nextInt(n);
            System.out.print(t + " ");
            sortArr[i] = t;
            arr[t]++;
        }
        System.out.println("\n排序后为:");

        for (int i = n-1; i >=0 ; i--) {
            for (int j = 1; j<=arr[i] ; j++) {
                System.out.print(i + " ");
            }
        }



    }
}
