package com.JVM;

public class InternTest {
    public static void main(String[] args) {
        String str1 = "xy";
        String str2 = "z";
        String str3 = "xyz";
        String str4 = str1 + str2;
        String str5 = str4.intern();
        String str6 = "xy" + "z";

        System.out.println(str3 == str4);
        System.out.println(str3 == str5);
        System.out.println(str3 == str6);
    }
}
