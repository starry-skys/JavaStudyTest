package algo.leetcode.daily;

import java.util.Arrays;

/**
 * @author Stephen
 * @date 2020/3/31 9:57
 * 912. 排序数组
 */
public class SortArrayTest {

    public static void main(String[] args) {
        SortArrayTest sort = new SortArrayTest();
        int[] nums = {2,5,3,2,5,6,3,10,9};
        sort.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    //用计数排序
    public  int[] sortArray(int[] nums) {
        //先找出数组中所有元素的最大值和最小值
        int min = -50000; int max = 50000;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }

        //数组中记录所有元素出现的次数
        int[] arr = new int[max - min + 1];
        for (int num : nums) {
            arr[num - min]++;
        }

        int x = 0;
        for (int num = min; num <= max; num++) {
            int c = arr[num - min];
            while (c > 0){
                nums[x++] = num;
                c--;
            }
        }

        return nums;
    }
}
