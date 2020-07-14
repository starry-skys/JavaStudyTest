package algo.leetcode.daily;

import algo.leetcode.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Stephen
 * @date 2020/3/29 11:52
 * 1162. 地图分析
 */
public class MaxDistanceTest {

    public static void main(String[] args) {
        System.out.println(Utils.transfer("[[1,0,0],[0,0,0],[0,0,0]]"));
        int[][] grid = {{1,0,0},{0,0,0},{0,0,0}};
        System.out.println(maxDistance(grid));
    }


    // {{1,0,1},{0,0,0},{1,0,1}}
    public static int maxDistance(int[][] grid) {
        int n = grid.length;

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        //定义一个queue，把所有陆地代表的坐标入队
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        //如果全是陆地或者全是水，返回 -1
        if(queue.isEmpty() || queue.size() == n*n){
            return -1;
        }

        int[] point = null;
        while (!queue.isEmpty()){
            point = queue.poll();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < directions.length; i++) {
                int[] dir = directions[i];
                int newX = x + dir[0];
                int nexY = y + dir[1];
                if(newX < 0 || newX >= n || nexY < 0 || nexY >= n || grid[newX][nexY] != 0){
                    continue;
                }
                //直接修改原数组，当前坐标位置的值就代表走过的路径距离
                grid[newX][nexY] = grid[x][y] + 1;
                queue.offer(new int[]{newX,nexY});
            }
        }

        //返回遍历到的最后一个位置的值，需要减 1才代表最终的距离。
        return grid[point[0]][point[1]] - 1;
    }
}
