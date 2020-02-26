package com.sort.bubble;

import java.util.Arrays;

/**
 * @Author wanbei
 * @DATE 2018/9/27 09:33
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,23,98,25,4,7,8,35};
        bubbleSort(arr);
        System.out.println("排序后为:");
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) { //总共需要比较（n-1）趟
            boolean sortedFlag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) { //每趟需要比较（n-i-1）次,i从0开始
                if(arr[j]>arr[j+1]){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    sortedFlag = false;
                }
            }
            if(sortedFlag) break;
        }
    }
}
