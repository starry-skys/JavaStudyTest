package algo.leetcode.weeks;

import algo.leetcode.Utils;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumTest {
    public static void main(String[] args) {
        System.out.println(Utils.transfer("[[1,10,4,2],[9,3,8,7],[15,16,17,12]]"));
        int[][] matrix = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};

        System.out.println(luckyNumbers(matrix));
    }

    //[[3,7,8],[9,11,13],[15,16,17]]
    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            int x = 0;
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    x = j;
                }
            }
            int max = matrix[i][x];
            for (int j = 0; j < matrix.length; j++) {
               if(matrix[j][x] > max){
                   max = matrix[j][x];
               }
            }

            if(max == min){
                list.add(max);
            }

        }

        return list;
    }
}
