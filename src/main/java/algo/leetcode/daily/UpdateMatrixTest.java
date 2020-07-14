package algo.leetcode.daily;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Stephen
 * @date 2020/4/15 19:12
 * 542. 01 矩阵
 */
public class UpdateMatrixTest {

    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };

        matrix = updateMatrix(matrix);
        for (int[] mat : matrix) {
            System.out.println(Arrays.toString(mat));
        }

    }

    //多源bfs，先把所有的0入队，1的位置设置为-1，表示未访问过
    public static int[][] updateMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        LinkedList<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int i = point[0]; int j = point[1];
            for (int[] dir : dirs) {
                int x = dir[0] + i;
                int y = dir[1] + j;
                if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] == -1) {
                    matrix[x][y] = matrix[i][j] + 1;
                    queue.offer(new int[]{x,y});
                }
            }
        }

        return matrix;
    }

}
