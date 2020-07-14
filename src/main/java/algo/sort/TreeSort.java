package algo.sort;

import java.util.Arrays;

/**
 * @author Stephen
 * @date 2020/4/2 21:39
 */
public class TreeSort {

    public static void main(String[] args) {
        int[] arr = {4,1,9,3,7,8,5,6,2};
        treeSort(arr);
    }

    //堆排序，降序
    private static void treeSort(int[] arr){
        //先构建一个最小堆
        for (int i = arr.length/2 - 1; i >= 0; i--) {
            adjustDown(arr,i,arr.length);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustDown(arr,0,i);
        }

        System.out.println(Arrays.toString(arr));
    }

    //最小值下沉，重新调整为最小堆
    private static void adjustDown(int[] arr, int parent, int length){
        int temp = arr[parent];
        int child = 2 * parent + 1;
        while (child < length){
            if(child + 1 < length && arr[child] > arr[child + 1]){
                child ++;
            }

            if(arr[child] < temp){
                arr[parent] = arr[child];
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }
        }
        arr[parent] = temp;
    }


}
