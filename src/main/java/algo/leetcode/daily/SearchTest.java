package algo.leetcode.daily;

/**
 * @author Stephen
 * @date 2020/4/27 21:26
 * 33. 搜索旋转排序数组
 */
public class SearchTest {

    public static void main(String[] args) {
        //4,5,6,7,0,1,2
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,0));
    }

    private static int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return -1;

        int left = 0;
        int right = len - 1;
        while (left < right){
            //向上取整中间数
            int mid = left + (right - left + 1) / 2;
            //若中位数小于右边界，则右半部分是有序的，否则左半部分是有序的
            if(nums[mid] < nums[right]){
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid;
                }else {
                    right = mid - 1;
                }
            }else {
                if(nums[left] <= target && target <= nums[mid-1]){
                    right = mid - 1;
                }else {
                    left = mid;
                }
            }
        }

        if(nums[right] == target){
            return left;
        }
        return -1;
    }
}
