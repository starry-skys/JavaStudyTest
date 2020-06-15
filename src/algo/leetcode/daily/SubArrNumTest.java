package algo.leetcode.daily;

/**
 * @author Stephen
 * @date 2020/4/21 23:02
 * 1248. 统计「优美子数组」
 */
public class SubArrNumTest {

    public static void main(String[] args) {
        //{2,2,2,1,2,2,1,2,2,2}
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println(numberOfSubarrays1(nums,k));
    }

    private static int numberOfSubarrays(int[] nums, int k) {
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num & 1;
            count[sum] ++;
            if(sum >= k){
                res += count[sum-k];
            }
        }

        return res;
    }

    private static int numberOfSubarrays1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        // 双指针
        int left = 0, right = 0;
        int count = 0; // 连续子数组中奇数的个数
        int res = 0;
        int preEven = 0; // 记录第一个奇数前面的偶数个数
        while (right < nums.length){
            // 连续子数组中奇数个数不够
            if (count < k){
                if (nums[right] % 2 != 0) count++;
                right++; // 移动右侧指针
            }
            // 连续子数组中奇数个数够了，看第一个奇数前面有多少个偶数
            if (count == k) {
                preEven = 0;
                while (count == k){
                    res++;
                    if (nums[left] % 2 != 0) count--;
                    left++;
                    preEven++;
                }
            } else {
                res += preEven; // 每次遇到 right 为偶数的时候就进行累加 相当于区间前面偶数个数 * 后面偶数个数
            }
        }
        return res;

    }
}
