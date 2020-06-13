package algo.recursive;

/**
 * @author Stephen
 * @date 2020/3/29 20:42
 * 小球回溯，迷宫问题
 */
public class MazeTest {
    static final int m = 8;
    static final int n = 7;

    public static void main(String[] args) {
        int a = 1;
        System.out.println(-a);
        int[][] map = createMaze();
        //小球位置为 1,1

//        step(map,1,1);
        //行走路径
        System.out.println("小球行走路径");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] createMaze(){
        int[][] map = new int[m][n];

        //第一列和最后一列为墙
        for (int i = 0; i < m; i++) {
            map[i][0] = 1;
            map[i][n-1] = 1;
        }
        //第一行和最后一行为墙
        for (int i = 0; i < n; i++) {
            map[0][i] = 1;
            map[m-1][i] = 1;
        }
        //其他墙
        map[3][1] = 1;
        map[3][2] = 1;
        //堵死
        map[1][2] = 1;
        map[2][2] = 1;

        //初始化地图
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        return map;
    }

    //小球行走策略优先级为 下，右，上，左
    private static boolean step(int[][] map , int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n) return false;
        //如果走到6,5，则结束
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] == 0){ //说明没有走过
                map[i][j] = 2;  //假定可以走通
                if(step(map, i+1, j)){
                    return true;
                }else if(step(map, i, j+1)){
                    return true;
                }else if(step(map, i-1, j)){
                    return true;
                }else if(step(map, i, j-1)){
                    return true;
                }else{
                    //若四个方向都走不通，就设为3
                    map[i][j] = 3;
                    return false;
                }
            }else{
                //1,2,3都直接返回false
                return false;
            }
        }

    }
}
