package algo.leetcode.daily;

/**
 * @author Stephen
 * @date 2020/4/8 10:29
 * 面试题13. 机器人的运动范围
 */
public class MoveCountTest {

    public static void main(String[] args) {
        int m = 16;
        int n = 8;
        int k = 4;
        System.out.println(movingCount(m,n,k));
    }

    private static int movingCount(int m, int n, int k) {
        int res = 0;
        int[][] grid = new int[m][n];
        res += dfs(0,0,m,n,k,grid);
        return res;
    }

    private static int dfs(int i, int j, int m, int n, int k, int[][] grid) {
        if(i < 0 || i >= m || j < 0 || j >= n || getSum(i,j) > k || grid[i][j] == 1){
            return 0;
        }
        int res = 1;
        //如果搜索过，设置为1，避免重复查找
        grid[i][j] = 1;
        //其实，只要向下或向右就可以了，四个方向可以优化为两个方向
        int[][] directions = {{0,1},{1,0}};
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            res += dfs(x,y,m,n,k,grid);
        }
        return res;
    }

    //计算三位数的各位数之和
    private static int sum(int a){
        int x = a % 10;
        int y = a / 10;
        return x+y;
    }

    private static int getSum(int x, int y){
        return sum(x) + sum(y);
    }
}
