package algo.leetcode.daily;

/**
 * @author Stephen
 * @date 2020/4/6 20:36
 * 72. 编辑距离
 */
public class WordTransfer {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    //word1 = "horse", word2 = "ros"  word1 = "intention", word2 = "execution"
    private static int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        int m = s1.length;
        int n = s2.length;

        //创建dp数组
        int[][] dp = new int[m+1][n+1];

        //初始化条件
        //s2为空，把 s1 全删除
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        //s1为空，全插入s2
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        //状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s1[i-1] == s2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]) + 1;
                }
            }
        }

        return dp[m][n];

    }
}
