package com.test.deliver;

/**
 * @Author zwb
 * @DATE 2020/1/7 11:05
 */
public class TestStr {
    public static void main(String[] args) {
        String str = new String("zhangsan");
        System.out.println("字符串修改前:"+str);
        changeStr(str);
        System.out.println("字符串修改后:"+str);
    }

    private static void changeStr(String str) {
        str = "lisi";
    }
}
