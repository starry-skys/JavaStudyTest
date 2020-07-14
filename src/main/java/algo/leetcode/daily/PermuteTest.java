package algo.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/25 12:46
 * 46. 全排列
 */
public class PermuteTest {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }

    //全排列
    private static List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(len <= 0) return res;

        //记录每次的排列
        ArrayList<Integer> path = new ArrayList<>();
        //用一个数组记录每个数字是否被使用过
        int[] used = new int[len];

        dfs(nums,len,0,path,used,res);
        return res;
    }

    private static void dfs(int[] nums, int len, int step,ArrayList<Integer> path, int[] used, ArrayList<List<Integer>> res) {
        //判断边界
        if(step == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            //若没有被使用，则加入
            if(used[i] == 0){
                path.add(nums[i]);
                used[i] = 1;
                //寻找下一个可用的数字
                dfs(nums,len,step+1,path,used,res);
                //使用后需要还原使用状态,并删除掉最后一个元素
                used[i] = 0;
                path.remove(path.size() - 1);
            }

        }
    }
}
