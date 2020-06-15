package algo.leetcode.daily;

import java.util.Arrays;

/**
 * @author Stephen
 * @date 2020/4/2 17:40
 * 289. 生命游戏
 */
public class LifeGameTest {

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

    }

    //核心就是统计周围活细胞个数就可以了。
    //因为细胞状态是同时变化，且数组是引用类型，因此不能在原来的数组上直接更改状态
    //所以可以利用int类型的倒数第二位保存细胞下一次变化的状态
    private static void gameOfLife(int[][] board) {
        if(board == null) return;
        //定义八个方向
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 0;
                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x < 0 || x >= n || y < 0 || y >= m){
                        continue;
                    }
                    //统计存活细胞
                    if((board[x][y] & 1) > 0){
                        count ++;
                    }
                }
                //如果当前细胞存活
                if((board[i][j] & 1) > 0){
                    //周围有2个或3个存活细胞，则存活
                    if(count == 2 || count == 3){
                        board[i][j] = 0b11;
                    }
                    //其他情况都死亡，但是原本值就是 0b01，故不用重新赋值
                }else {
                    //如果当前细胞死亡，并且周围有3个细胞存活，则存活
                    if(count == 3){
                        board[i][j] = 0b10;
                    }
                }
            }
        }

        //最后把二进制位右移一位，则得到当前细胞的存活状态
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] >>= 1;
            }
        }


    }
}
