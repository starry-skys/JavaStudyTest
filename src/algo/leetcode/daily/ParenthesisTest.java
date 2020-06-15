package algo.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/9 18:13
 * 22. 括号生成
 */
public class ParenthesisTest {

    public static void main(String[] args) {
        int n = 3;
        List<String> list = generateParenthesis(n);
        System.out.println(list);
    }

    //做减法
    public static List<String> generateParenthesis(int n) {
        if(n == 0) return null;
        ArrayList<String> res = new ArrayList<>();

        dfs("",n,n,res);
        return res;
    }

    /**
     *
     * @param str  当前递归拼接成的字符串
     * @param left  左括号剩余可用个数
     * @param right 右括号剩余可用个数
     * @param res 最终结果
     */
    private static void dfs(String str, int left, int right, ArrayList<String> res) {
        //递归终止时，把字符串加入到res
        if(left == 0 && right == 0){
            res.add(str);
            return;
        }
        //每次递归时需要保证左括号可用个数小于右括号个数，若大于则结束
        if(left > right) return;

        if(left > 0){
            dfs(str + "(",left-1,right,res);
        }

        if(right > 0){
            dfs(str + ")",left,right -1,res);
        }
    }
}
