package algo.leetcode.daily;

/**
 * @author Stephen
 * @date 2020/4/20 20:48
 * 200. 岛屿数量
 *
 */
public class NumIslandTest {

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    count ++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, char[][] grid) {
        if(i < 0 || i > grid.length -1 || j < 0 || j > grid[i].length - 1 || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(x,y,grid);
        }
    }
}
