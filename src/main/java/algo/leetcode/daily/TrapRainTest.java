package algo.leetcode.daily;

import java.util.Stack;

/**
 * @author Stephen
 * @date 2020/4/4 13:46
 * 42. 接雨水
 */
public class TrapRainTest {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap2(height));
    }


    //按列求每一列可存的水
    private static int trap(int[] height) {
        int sum = 0;
        //最左边和最右边不会存水，所以不用考虑
        for (int i = 1; i < height.length - 1; i++) {
            //循环找到当前列左边最高的墙
            int leftHeight = 0;
            for (int j = i - 1; j >= 0; j--) {
                if(height[j] > leftHeight){
                    leftHeight = height[j];
                }
            }
            //循环找到当前列后边最高的墙
            int rightHeight = 0;
            for (int j = i + 1; j < height.length; j++) {
                if(height[j] > rightHeight){
                    rightHeight = height[j];
                }
            }
            //比较得出两边最小的墙，和当前列作比较
            int min = Math.min(leftHeight,rightHeight);
            if(min > height[i]){
                sum += (min - height[i]);
            }

        }

        return sum;
    }

    //动规，用两个数组分别存储所有列的左、右最高墙
    private static int trap1(int[] height) {
        int sum = 0;
        // maxLeft[i]代表第i列左边最高墙的高度,right同理
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        //第i列左边最高墙的高度，为第i-1列左边最高墙高度和第i-1列墙高最大值
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1],height[i-1]);
        }
        //第i列右边最高墙，为第i+1列右边最高墙和第i+1列墙高最大值
        for (int i = height.length - 2; i >= 1; i--) {
            maxRight[i] = Math.max(maxRight[i+1],height[i+1]);
        }
        //第i列左右高最小值减去当前列高度
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i],maxRight[i]);
            if(min > height[i]){
                sum += (min - height[i]);
            }
        }

        return sum;
    }

    //用双指针优化动规
    private static int trap2(int[] height) {
        int sum = 0;
        //左、右最大值
        int maxLeft = 0,maxRight = 0;
        //左右指针下标
        int left = 1;
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            //如果height[left - 1] < height[right + 1]，说明左最大值大于右最大值
            //则可以放心的用左最大值计算水量，并指针右移，反之
            if(height[left - 1] < height[right + 1]){
                maxLeft = Math.max(maxLeft,height[left - 1]);
                int min = maxLeft;
                if(min > height[left]){
                    sum += (min - height[left]);
                }
                left ++;
            }else {
                maxRight = Math.max(maxRight,height[right + 1]);
                int min = maxRight;
                if(min > height[right]){
                    sum += (min - height[right]);
                }
                right --;
            }
        }
        return sum;
    }

    //用栈，可求多列水量
    private static int trap3(int[] height) {
        int sum = 0;
        //当前的指针指向的下标
        int current = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length){
            //当栈不为空，并且当前指针指向的值大于栈顶元素则循环
            while (!stack.empty() && height[current] > height[stack.peek()]){
                //记录当前栈顶所代表的的元素，用于计算水量
                int h = height[stack.pop()];
                //如果栈空则退出
                if(stack.empty()) break;
                //当前新的栈顶下标
                int topIndex = stack.peek();
                //计算新栈顶到当前指针之间的距离和它们对应的元素最小值
                int distance = current - topIndex - 1;
                int min = Math.min(height[topIndex],height[current]);
                sum += distance * (min - h);
            }
            //把当前下标入栈，并指针后移
            stack.push(current);
            current ++;
        }
        return sum;
    }
}
