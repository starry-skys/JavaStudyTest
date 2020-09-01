package algo.leetcode.daily;

import algo.leetcode.Utils;

/**
 * @author Stephen
 * @date 2020/3/26 14:35
 * 999. 车的可用捕获量
 */
public class RookTest {

    public static void main(String[] args) {
        System.out.println(Utils.transfer("[[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"p\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"p\",\".\",\".\",\".\",\".\"],[\"p\",\"p\",\".\",\"R\",\".\",\"p\",\"B\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"B\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"p\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"]]\n" +
                "\n").replaceAll("\"","\'"));

        char[][] arr = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        System.out.println(numRookCaptures(arr));
    }

    //
    public static int numRookCaptures(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 'R'){
                    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
                    for (int k = 0; k < directions.length; k++) {
                        int[] dir = directions[k];
                        if(isCollide(board,i,j,dir)){
                            res ++;
                        }
                    }
                    return res;
                }
            }
        }
        return 0;
    }

    //是否碰撞到敌人
    private static boolean isCollide(char[][] board, int i, int j, int[] dir) {
        int x = i, y = j;

        while (true){
            if(x < 0 || x >= board.length || y < 0 || y >= board[0].length){
                return false;
            }

            if(board[x][y] == 'B'){
                return false;
            }

            if(board[x][y] == 'p'){
                return true;
            }

            x += dir[0];
            y += dir[1];

        }
    }
}
