package com.sort;

import java.util.Arrays;

/**
 *
 * @DATE 2019/9/9 16:07
 */
public class ShellSort {
   public static void sort(int[] arr){
       int d = arr.length; //希尔排序的增量
       while (d > 1){
           d = d/2;
           for(int x=0; x< d ; x++){
               for(int i = x+d; i< arr.length; i=i+d){
                   int temp = arr[i];
                   int j = i -d;
                   for(; j >=0 && arr[j]>temp; j=j-d){
                       arr[j+d] = arr[j];
                   }
                   arr[j+d] = temp;
               }
           }
       }
   }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 2, 6, 4, 7, 11, 23, 44, 3, 34};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
