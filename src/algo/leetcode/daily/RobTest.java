package algo.leetcode.daily;

import java.util.Arrays;

/**
 * @author Stephen
 * @date 2020/3/26 21:08
 * 198. 打家劫舍
 */
public class RobTest {
    String name ;
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob2(nums));

        final int[] arr = {1};
        arr[0] = 2;
        System.out.println(Arrays.toString(arr));

        String s = new String("abc");
        String s3 = s.intern();
        String s1 = "abc";
        System.out.println(s == s1);

        RobTest t1 = new RobTest();
        RobTest t2 = new RobTest();
        System.out.println(t1.hashCode());
        System.out.println(t2.hashCode());

    }

    @Override
    public int hashCode() {
        return 1;
    }

    // {1,2,3,1}  {2,7,9,3,1}
    public static int rob(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];

        //dp[i][0] 代表[0-i]区间的房间偷到的最高金额，0代表下标为i的房间，不可偷
        //dp[i][1] 代表[0-i]区间的房间偷到的最高金额，1代表下标为i的房间可以偷
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[n-1][0],dp[n-1][1]);
    }

    //用一维数组dp[i] 代表[0-i]区间的房间偷到的最高金额，包括这天偷或者不偷
    public static int rob1(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int[] dp = new int[n];
        //如果只有一个房间，那么必偷
        dp[0] = nums[0];
        //如果只有两个房间，可以偷第一个或者第二个取最大
        dp[1] = Math.max(nums[0],nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i] , dp[i-1]);
        }

        return dp[n-1];
    }

    // 由于第i个房间的状态只和前两天的状态相关，因此可以用两个变量保存前两天的状态。
    public static int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        int a = 0, b = 0 , c = 0;

        for (int i = 0; i < n; i++) {
            c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}
