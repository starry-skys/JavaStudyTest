package algo.leetcode.daily;

import java.util.Arrays;

/**
 * @author Stephen
 * @date 2020/3/22 13:15
 *  no.945
 */
public class UniqueArrayTest {

    public static void main(String[] args) {
        int[] arr =  {0,0};
        System.out.println(minIncrementForUnique1(arr));
    }

    //  {3,2,1,2,1,7}   {1,2,2}
    public static int minIncrementForUnique(int[] arr) {
        //先升序排序
        Arrays.sort(arr);
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] <= arr[i-1]){
                int tmp = arr[i];
                //后边的数字只要改为比它前面的数字大1即可
                arr[i] = arr[i-1] + 1;
                //统计当前数的变化值
                res += arr[i] - tmp;
            }
        }
        return res;
    }


    public static int minIncrementForUnique1(int[] arr) {

        int[] nums = new int[80000];
        for (int i : arr) {
            nums[i] ++;
        }

        int res = 0;
        int takens = 0;

        for (int x = 0; x < nums.length; x++) {
            if(nums[x] > 1){
                takens += nums[x] - 1;
                res -= x * (nums[x] - 1); //先把n多个额外的数减去
            }else if(nums[x] == 0 && takens > 0){
                takens --;
                res += x;
            }
        }
        return res;
    }
}
