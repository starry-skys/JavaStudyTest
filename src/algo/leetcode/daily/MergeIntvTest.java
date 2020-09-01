package algo.leetcode.daily;

import java.util.Arrays;

/**
 * @author Stephen
 * @date 2020/4/16 20:03
 * 56. 合并区间
 */
public class MergeIntvTest {

    public static void main(String[] args) {
        //[[1,3],[2,6],[8,10],[15,18]]
//        Utils.transfer("[[1,3],[2,6],[8,10],[15,18]]");
        int[][] intervals = {{2,6},{1,3},{8,10},{15,18}};
        int[][] merge = merge(intervals);
        for (int[] arr : merge) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int[][] merge(int[][] intervals){
        //先把区间从小到大排序
        Arrays.sort(intervals,(v1,v2) -> {
            return v1[0] - v2[0];
        });
        int len = intervals.length;
        int[][] res = new int[len][2];

        int x = -1;
        for (int[] interval : intervals) {
            //如果结果数组为空，或者当前区间的最小值大于结果数组的最大值，
            //则把当前区间加入到res
            if(x == -1 || interval[0] > res[x][1]){
                res[++x] = interval;
            }else{
                //否则合并结果数组和当前区间
                res[x][1] = Math.max(res[x][1],interval[1]);
            }
        }
        //把后边的[0,0]数组都删掉
        return Arrays.copyOf(res,x+1);
    }
}
