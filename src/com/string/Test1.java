package com.string;

/**
 *
 * @DATE 2018/9/28 14:16
 */
public class Test1 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = s1;

        System.out.println(s1 == s2);

        s1 = s1.concat("ef");
        System.out.println(s1 == s2);
    }
}
