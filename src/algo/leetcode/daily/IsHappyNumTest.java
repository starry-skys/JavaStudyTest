package algo.leetcode.daily;

import java.util.HashSet;

/**
 * @author Stephen
 * @date 2020/4/30 11:14
 * 202. 快乐数
 */
public class IsHappyNumTest {

    public static void main(String[] args) {
        //19
        int n = 19;
        System.out.println(isHappy1(n));
    }

    private static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1){
            n = change(n);
            if(set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }

    //计算各个位的平方和，有可能有多个位，不能只考虑两位数
    private static int change(int n) {
        int sum = 0;
        int num = 0;
        while(n != 0){
            num = n % 10;//最后一位
            n = n / 10; //前面的所有位
            sum += num * num;
        }
        return sum;
    }

    private static boolean isHappy1(int n) {
        int slow = n;
        int fast = getNext(n);
        while(fast != 1 && fast != slow){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private static int getNext(int n) {
       return change(n);
    }
}
