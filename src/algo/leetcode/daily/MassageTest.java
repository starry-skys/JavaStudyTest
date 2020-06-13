package algo.leetcode.daily;

/**
 * @author Stephen
 * @date 2020/3/24 11:01
 * 面试题 17.16. 按摩师
 */
public class MassageTest {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(massage1(nums));
    }

    // {2,1,4,5,3,1,1,3}  {1,2,3,1}  {2,7,9,3,1}
    public static int massage(int[] nums) {
        //递推方程：dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        int n = nums.length;
        if(n == 0 ) return 0;
        if(n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }

       return dp[n-1];
    }

    public static int massage1(int[] nums) {

        int a = 0, b = 0;

        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b,a + nums[i]);
            a = b;
            b = c;
        }

        return b;
    }

    public int massage2(int[] nums) {
        int first=0;
        int second=0;
        for(int i:nums){
            int temp=second;
            second=Math.max(second,first+i);
            first=temp;
        }
        return second;
    }


}
