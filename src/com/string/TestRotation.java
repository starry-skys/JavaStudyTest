package com.string;

/**
 *
 * @DATE 2018/12/4 16:27
 */
public class TestRotation {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bcda";
        System.out.println(checkRotation(s1,s2));
    }

    public static boolean checkRotation(String a,String b){
        int al = a.length();
        int bl = b.length();
        if(a==null||b==null||al!=bl){
            return false;
        }
        String s = a + a;
        return s.contains(b);
    }
}
