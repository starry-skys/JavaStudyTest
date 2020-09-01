package algo.leetcode.hot100;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Stephen
 * @date 2020/6/15 22:44
 */
public class twoSumTest {

    @Test
    public void test(){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{i,map.get(nums[i])};
            }else {
                map.put(target-nums[i],i);
            }
        }
        return null;
    }
}
