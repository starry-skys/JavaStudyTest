package cn.mytest;

import java.util.Arrays;

public class Test {
    @org.junit.Test
    public void test1(){
        Integer a = new Integer(1000);
        int b = 1000;
        Integer c = new Integer(1000);
        System.out.println(a == b);
        System.out.println(a == c);
    }

    @org.junit.Test
    public void test2(){
        int[] arr = {2,3,5,4,10,6,8,7,9,11,18,14,15};
        int min = arr[0];
        int max = arr[0];
        int[] mins = {min,min,min,min,min};
        int[] maxs = {max,max,max,max,max};
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > maxs[0]){
                maxs[0] = arr[i];
                for (int j = 1; j < maxs.length; j++) {
                    if(arr[i]>maxs[j]){
                        int temp = maxs[j-1];
                        maxs[j-1] = maxs[j];
                        maxs[j] = temp;
                    }
                }
            }
//            if(arr[i] < min){
//                min = arr[i];
//            }
        }
        System.out.println(Arrays.toString(maxs));
//        System.out.println(min);
    }
}
