package algo.leetcode.daily;

/**
 * @author Stephen
 * @date 2020/4/17 20:51
 * 55. 跳跃游戏
 */
public class CanJumpTest {

    public static void main(String[] args) {
        //2,3,1,1,4
        int[] nums = {0};
        System.out.println(canJump(nums));

    }

    private static boolean canJump(int[] nums) {
        int len = nums.length;

        if(nums == null || len == 0){
            return false;
        }
        //倒推
        int end = len - 1;
        for (int i = end; i >= 0; i--) {
            if(i == 0 && nums[0] >= end){
                return true;
            }
            if(nums[i] + i >= end){
                end = i;
            }
        }

        return false;
    }
}
