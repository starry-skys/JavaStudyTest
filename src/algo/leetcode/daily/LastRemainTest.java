package algo.leetcode.daily;

import java.util.ArrayList;

/**
 * @author Stephen
 * @date 2020/3/30 16:53
 * 面试题62. 圆圈中最后剩下的数字，其实就是约瑟夫环问题
 */
public class LastRemainTest {

    public static void main(String[] args) {
        System.out.println(lastRemaining2(5, 3));
    }


    /**
     * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
     * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     *
     */
    public static int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        //当前需要删除元素的下标
        int x = 0;
        while (n > 1){
            //下一个需要删除的元素下标
            x = (x + m - 1) % n;
            list.remove(x);
            n --;
        }

        return list.get(0);
    }

    //ArrayList移除元素，效率太低，考虑用反推法，把最后能留下的那个元素的下标求出来
    public static int lastRemaining1(int n, int m) {
        int res = 0;
        //最后剩两个元素，于是从2开始反推
        for(int i = 2; i <= n; i++){
            res = (res + m) % i;
        }

        return res;
    }

    //递推公式 lastRemaining(n, m) = ( lastRemaining(n-1, m) + m ) % n
    public static int lastRemaining2(int n, int m) {
        if(n == 2){
            //当剩下两个人时，判断m是偶数，则下标为0的人存活
            return (m & 1) == 0 ? 0 : 1;
        }

        return (lastRemaining2(n-1,m) + m) % n;
    }
}
