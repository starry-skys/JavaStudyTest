package algo.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/10 17:03
 * 151. 翻转字符串里的单词
 */
public class ReverseWordsTest {

    public static void main(String[] args) {
        String s = " ";
        System.out.println(reverseWords1(s));
    }

    private static String reverseWords(String s) {
        if(s == null || s.length() == 0) return null;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++ ) {
            char c = chars[i];
            if(c != 32){
                sb.append(c);
                if(i == chars.length -1 && sb.length() > 0){
                    list.add(sb.toString());
                    break;
                }
            }else {
                if(sb.length() > 0){
                    list.add(sb.toString());
                    sb.delete(0,sb.length());
                }
                continue;
            }
        }

        if(list.size() <= 0) return "";
        StringBuilder res = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            res.append(" ").append(list.get(i));
        }
        return res.substring(1);
    }

    private static String reverseWords1(String s) {
        s = s.trim();
        if("".equals(s)) return "";
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            String str = arr[i].trim();
            if("".equals(str)) continue;
            sb.append(" ").append(str);
        }
        return sb.substring(1);
    }
}
