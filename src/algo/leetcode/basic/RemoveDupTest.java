package algo.leetcode.basic;

import org.junit.Test;

/**
 * @author Stephen
 * @date 2020/6/15 22:03
 */
public class RemoveDupTest {
    //0,0,1,1,1,2,2,3,3,4

    @Test
    public void test(){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int flag = nums[0] - 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == cur){
                nums[i] = flag;
            }else {
                cur = nums[i];
            }
        }

        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i] != flag){
                res ++;
            }
        }
        return res;
    }
}
