package com.sort;

import java.util.Arrays;

/**
 *
 * @DATE 2019/7/15 09:04
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{2,19,39,24,32,1,43,25};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void selectSort(int[] array){
        for(int i = 0; i< array.length -1; i++){
            int minIndex = i;
            for(int j = i+1; j<array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
