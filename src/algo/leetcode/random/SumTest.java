package algo.leetcode.random;


import java.util.Arrays;
import java.util.HashMap;

public class SumTest {
    public static void main(String[] args) {
        int[] arr =  {2, 7, 11, 15};

        int[] result = sumTwo1(arr , 13);
        System.out.println(Arrays.toString(result));

    }

    private static int[] sumTwo(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    private static int[] sumTwo1(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }

            map.put(nums[i],i);
        }
        return null;
    }


}
