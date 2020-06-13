package algo.leetcode.daily;

/**
 * @author Stephen
 * @date 2020/4/24 21:34
 * 面试题51. 数组中的逆序对
 */
public class ReversePairsTest {

    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;

        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[n];
        return reversePairs(copy,0,n-1,temp);
    }

    private static int reversePairs(int[] nums, int left, int right, int[] temp) {
        if(left == right){
            return 0;
        }

        int mid = left + (right - left)/2;
        int leftPairs = reversePairs(nums,left,mid,temp);
        int rightPairs = reversePairs(nums,mid+1,right,temp);

        //如果整个数组有序，则不需要合并
        if(nums[mid] <= nums[mid+1]){
            return leftPairs + rightPairs;
        }

        int merge = mergeAndCount(nums,left,mid,right,temp);
        return leftPairs + rightPairs + merge;

    }

    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {
            //判断越界
            if(i == mid + 1){
                nums[k] = temp[j];
                j ++;
            }else if(j == right + 1){
                nums[k] = temp[i];
                i ++;
            }else if(temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            }else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
