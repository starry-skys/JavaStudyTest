package algo.leetcode.daily;

import algo.leetcode.Utils;

/**
 * @author Stephen
 * @date 2020/3/25 11:16
 * 892. 三维形体的表面积
 */
public class SurfaceAreaTest {

    public static void main(String[] args) {
        System.out.println(Utils.transfer("[[1,1,1],[1,0,1],[1,1,1]]"));
        int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(surfaceArea1(grid));
    }

    // [[1,2],[3,4]] {{1,1,1},{1,0,1},{1,1,1}}
    //计算右边和后边的重合部分
    public static int surfaceArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) continue;
                res += grid[i][j] > 1 ? 6* (grid[i][j]) - 2 * (grid[i][j] - 1) : 6;
                if(j < grid[i].length - 1 && grid[i][j+1] != 0){
                    res -= 2 * Math.min(grid[i][j],grid[i][j+1]);
                }

                if(i < grid.length - 1 && grid[i+1][j] != 0){
                    res -= 2 * Math.min(grid[i][j],grid[i+1][j]);
                }
            }

        }
        return res;
    }

    //计算左边和前边的重合部分
    public static int surfaceArea1(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] > 0){
                    res += 4* grid[i][j] + 2; //四个侧面和两个上下底面
                    //计算左边重合的部分
                    res -= j > 0 ? 2 * Math.min(grid[i][j],grid[i][j-1]) : 0;
                    //计算前面重合的部分
                    res -= i > 0 ? 2 * Math.min(grid[i][j],grid[i-1][j]) : 0;
                }
            }
        }
        return res;
    }
}
