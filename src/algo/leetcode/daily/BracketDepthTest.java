package algo.leetcode.daily;

import java.util.Arrays;

/**
 * @author Stephen
 * @date 2020/4/1 15:03
 * 1111. 有效括号的嵌套深度
 */
public class BracketDepthTest {

    public static void main(String[] args) {
        String seq = "()(())()";
        int[] res = maxDepthAfterSplit(seq);
        System.out.println(Arrays.toString(res));
    }

    // ()(())() [0,0,0,1,1,0,1,1]
    private static int[] maxDepthAfterSplit(String seq) {
        int[] arr = new int[seq.length()];
        int x = 0;
        for (char c : seq.toCharArray()) {
            arr[x] = c == '(' ? x & 1 : ((x+1) & 1);
            x++;
        }
        return arr;
    }
}
