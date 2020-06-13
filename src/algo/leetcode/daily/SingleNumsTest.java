package algo.leetcode.daily;

import java.util.Arrays;

/**
 * @author Stephen
 * @date 2020/4/28 10:52
 * 面试题56 - I. 数组中数字出现的次数
 */
public class SingleNumsTest {

    public static void main(String[] args) {
        //1,2,10,4,1,4,3,3
        int[] nums = {1,2,10,4,1,4,3,3};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }

    private static int[] singleNumbers(int[] nums) {
        int r = 0;
        //所有数字进行异或，得到的最终结果，就是那两个不同的数字的异或结果
        for (int num : nums) {
            r ^= num;
        }

        //说明这两个不同的数字，肯定会有一个位为0和1，找到它们最低位不同的位，根据它做分组
        int mask = r & (-r);
        int[] res = new int[2];
        for (int num : nums) {
            if((num & mask) == 0){
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }
        return res;
    }
}
