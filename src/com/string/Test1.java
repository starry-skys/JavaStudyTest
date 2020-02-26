package com.string;

/**
 * @Author wanbei
 * @DATE 2018/9/28 14:16
 */
public class Test1 {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");
        String s3 = "abc";
        String s4 = "abc";

        System.out.println(s1==s2);
//        System.out.println(s1);

        System.out.println(s1==s3);
        System.out.println(s4==s3);
//        System.out.println(s3);
    }
}
