package algo.leetcode;

public class Utils {
    public static String transfer(String s){
        String res = s.replace("[","{").replace("]","}");
        System.out.println(res);
        return res;
    }
}
