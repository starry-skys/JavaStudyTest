package algo.leetcode.daily;

/**
 * @author Stephen
 * @date 2020/4/18 20:40
 * 11. 盛最多水的容器
 */
public class MaxAreaTest {

    public static void main(String[] args) {
        //1,8,6,2,5,4,8,3,7
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }


    //双指针
    private static int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        //两个指针，分别从左边和右边移动，因水的容量和距离还有两个柱子中高度最小的关系最大
        //因此，当左边高度小时，就左边指针右移，若右边高度较小时，就右边指针左移。相等，则都移动
        while (left < right){
            int area = (right - left) * Math.min(height[left],height[right]);
            res = Math.max(res,area);
            if(height[left] < height[right]){
                left ++;
            }else if(height[left] > height[right]){
                right --;
            }else{
                left ++;
                right --;
            }
        }

        return res;
    }
}
