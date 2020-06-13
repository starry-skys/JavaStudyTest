package algo.leetcode.daily;

import java.util.Arrays;

/**
 * @author Stephen
 * @date 2020/4/7 14:40
 * 面试题 01.07. 旋转矩阵
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(matrix);

    }

    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) return;

        //先左上和右下对角线翻转
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //再对每一行，以中心点翻转
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
