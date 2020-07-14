package algo.tree;

import java.util.Arrays;

/**
 * @author Stephen
 * @date 2020/3/31 23:04
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4,1,9,3,7,8,5,6,2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //堆排序，大顶堆，升序
    private static void heapSort(int[] arr){
        //构建一个大顶堆，从最下面的非叶子节点开始向上遍历
        for (int i = arr.length/2 - 1 ; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        System.out.println(Arrays.toString(arr));
        //循环执行以下操作：1.交换堆顶元素和末尾元素2.重新调整为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶最大的元素与末尾元素互换，则数组中最后的元素变为最大值
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //从堆顶开始重新调整结构，使之成为大顶堆
            // i代表当前数组需要调整的元素个数，是逐渐递减的
            adjustHeap(arr,0,i);
        }

    }


    /**
     * 调整为大顶堆
     * @param arr   待调整的数组
     * @param parent   当前父节点的下标
     * @param length   需要对多少个元素进行调整
     */
    private static void adjustHeap(int[] arr, int parent, int length){
        //临时保存要下沉的元素
        int temp = arr[parent];
        //左子节点
        int child = 2 * parent + 1;

        while(child < length){
            //判断左子节点和右子节点的大小,若右边大，则把child定位到右边
            if(child + 1 < length && arr[child] < arr[child + 1]){
                child ++;
            }
            //若child大于父节点，则交换位置，否则退出循环
            if(arr[child] > temp){
                //父子节点交换位置
                arr[parent] = arr[child];
                //因为交换位置之后，不能保证当前的子节点是它子树的最大值，所以需要继续向下比较，
                //把当前子节点设置为下次循环的父节点，同时，找到它的左子节点，继续下次循环
                parent = child;
                child = 2 * parent + 1;
            }else{
                //如果当前子节点小于等于父节点，则说明此时的父节点已经是最大值了，
                //因此无需继续循环
                break;
            }
        }
        //把 temp 放到调整后的位置
        arr[parent] = temp;
    }

}
