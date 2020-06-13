package com.sort.bucket;

import java.util.Scanner;

/**
 *
 * @DATE 2018/9/26 16:42
 * 桶排序
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] arr = new int[1001];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入有几个数:");
        int n = sc.nextInt();
        System.out.println("请依次输入这几个数:");
        for(int i=1;i<=n;i++){
            int t = sc.nextInt();
            arr[t]++;
        }

        for(int i = 1000; i>0 ;i--){
            for (int j = 1; j <= arr[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }

}
