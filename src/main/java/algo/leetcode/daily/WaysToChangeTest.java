package algo.leetcode.daily;

/**
 * @author Stephen
 * @date 2020/4/23 19:49
 * 面试题 08.11. 硬币
 */
public class WaysToChangeTest {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(waysToChange(n));
    }

    private static int waysToChange(int n) {
        int[] coins = new int[]{1,5,10,25};
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
               dp[i] = (dp[i] + dp[i-coin]) % 1000000007;
            }
        }
        return dp[n];
    }
}
