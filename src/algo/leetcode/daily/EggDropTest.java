package algo.leetcode.daily;

import java.util.Arrays;

/**
 * @author Stephen
 * @date 2020/4/11 20:35
 * 887. 鸡蛋掉落
 */
public class EggDropTest {

    public static void main(String[] args) {
        int k = 3;
        int n = 14;
        System.out.println(superEggDrop1(k, n));
    }


    //会超时
    private static int superEggDrop(int K, int N) {
        //dp[i][j]代表一共有i层楼梯的情况下，使用j个鸡蛋最少实验次数
        int[][] dp = new int[N+1][K+1];
        //初始化，因为是求最小值，因此把每个单元格都赋值一个较大值，
        //因最大值超不过楼层高度，取i即可
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i],i);
        }

        //0行，由于是0层，不管多少个鸡蛋都是0
        for (int i = 0; i <= K; i++) {
            dp[0][i] = 0;
        }
        //1行，即1层，0个鸡蛋则为0次，大于等于1个鸡蛋，都是1次
        dp[1][0] = 0;
        for (int i = 0; i <= K; i++) {
            dp[1][i] = 1;
        }
        //0列，当鸡蛋为0的时候，不管几层结果都是0
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        //1列，当鸡蛋为1的时候，总共几层，结果就是几次
        for (int i = 0; i <= N; i++) {
            dp[i][1] = i;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                // x>=1 x<=i
                for (int x = 1; x <= i; x++) {
                    //从x层开始扔，如果碎了，则层数减1，鸡蛋也减少1
                    //如果没碎，则层数为 i - x，鸡蛋不变
                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[x-1][j-1],dp[i-x][j]) + 1);

                }
            }
        }

        return dp[N][K];
    }

    private static int superEggDrop1(int K, int N) {
        //dp[i][j]代表一共有i层楼梯的情况下，使用j个鸡蛋最少实验次数
        int[][] dp = new int[N+1][K+1];
        //初始化，因为是求最小值，因此把每个单元格都赋值一个较大值，
        //因最大值超不过楼层高度，取i即可
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i],i);
        }

        //0行，由于是0层，不管多少个鸡蛋都是0
        for (int i = 0; i <= K; i++) {
            dp[0][i] = 0;
        }
        //1行，即1层，0个鸡蛋则为0次，大于等于1个鸡蛋，都是1次
        dp[1][0] = 0;
        for (int i = 0; i <= K; i++) {
            dp[1][i] = 1;
        }
        //0列，当鸡蛋为0的时候，不管几层结果都是0
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        //1列，当鸡蛋为1的时候，总共几层，结果就是几次
        for (int i = 0; i <= N; i++) {
            dp[i][1] = i;
        }

        // 开始递推
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                // 在区间 [1, i] 里确定一个最优值
                int left = 1;
                int right = i;
                while (left < right) {
                    // 找 dp[k - 1][j - 1] <= dp[i - mid][j] 的最大值 k
                    int mid = left + (right - left + 1) / 2;

                    int breakCount = dp[mid - 1][j - 1];
                    int notBreakCount = dp[i - mid][j];
                    if (breakCount > notBreakCount) {
                        // 排除法（减治思想）写对二分见第 35 题，先想什么时候不是解
                        // 严格大于的时候一定不是解，此时 mid 一定不是解
                        // 下一轮搜索区间是 [left, mid - 1]
                        right = mid - 1;
                    } else {
                        // 这个区间一定是上一个区间的反面，即 [mid, right]
                        // 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
                        left = mid;
                    }
                }
                // left 这个下标就是最优的 k 值，把它代入转移方程 Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1) 即可
                dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
            }
        }


        return dp[N][K];
    }
}
