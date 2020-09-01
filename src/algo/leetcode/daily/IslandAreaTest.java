package algo.leetcode.daily;

/**
 * 695. 岛屿的最大面积
 */
public class IslandAreaTest {

    public static void main(String[] args) {
//        String str = "[[0,0,1,0,0,0,0,1,0,0,0,0,0],\n" +
//                " [0,0,0,0,0,0,0,1,1,1,0,0,0],\n" +
//                " [0,1,1,0,1,0,0,0,0,0,0,0,0],\n" +
//                " [0,1,0,0,1,1,0,0,1,0,1,0,0],\n" +
//                " [0,1,0,0,1,1,0,0,1,1,1,0,0],\n" +
//                " [0,0,0,0,0,0,0,0,0,0,1,0,0],\n" +
//                " [0,0,0,0,0,0,0,1,1,1,0,0,0],\n" +
//                " [0,0,0,0,0,0,0,1,1,0,0,0,0]]";
//        System.out.println(transfer(str));
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(grid));
    }



    //[[0,0,1,0,0,0,0,1,0,0,0,0,0],
    // [0,0,0,0,0,0,0,1,1,1,0,0,0],
    // [0,1,1,0,1,0,0,0,0,0,0,0,0],
    // [0,1,0,0,1,1,0,0,1,0,1,0,0],
    // [0,1,0,0,1,1,0,0,1,1,1,0,0],
    // [0,0,0,0,0,0,0,0,0,0,1,0,0],
    // [0,0,0,0,0,0,0,1,1,1,0,0,0],
    // [0,0,0,0,0,0,0,1,1,0,0,0,0]]
    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    res = Math.max(res,dfs(grid,i,j));
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0){
            return 0;
        }
        int res = 1;
        //如果已经搜索过，则改为0，避免重复查找
        grid[i][j] = 0;
        //四个方向
        int[] h = { 1, -1, 0, 0};
        int[] v = { 0, 0, 1, -1};
        for (int k = 0; k < 4; k++) {
            int x = h[k] + i;
            int y = v[k] + j;
            res += dfs(grid,x,y);
        }
        return res;
    }


}