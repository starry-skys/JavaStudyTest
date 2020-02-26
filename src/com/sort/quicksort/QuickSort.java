package com.sort.quicksort;

import java.util.Random;

/**
 * @Author wanbei
 * @DATE 2018/9/27 14:30
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int n = 11;
        Random random = new Random();
        int length = n-1;
        int[] sortArr = new int[length];
//        int[] sortArr = {6,1,2,7,9,3,4,5,10,8};

        System.out.println("排序前:");
        for (int i = 0; i < length; i++) {
            int t = random.nextInt(n);
            System.out.printf(t + " ");
            sortArr[i] = t;
        }

        sort(sortArr,0,length-1);

        System.out.println("\n排序后:");
        for (int i = 0; i < sortArr.length; i++) {
            System.out.printf(sortArr[i] + " ");
        }

    }


    public static void sort(int[] a, int left, int right){

        if(left>right){
            return;
        }
        int i = left;
        int j = right;
        int temp = a[left];

        while(i != j){
            while(a[j]>=temp && i< j){
                j--;
            }
            while(a[i]<=temp && i< j){
                i++;
            }
            //交换i和j位置的数字
            if(i<j){
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        //当i和j碰头,即相等时,把基准数即假设的第一个位置数归位
        a[left] = a[i];
        a[i] = temp;

        sort(a,left,i-1);
        sort(a,i+1,right);

    }
}
