package com.JVM;

/**
 * @author Stephen
 * @date 2020/5/5 9:20
 */
public class TestAnno {
    public static void main(String[] args) {
        String str = "张三";
        // \u000d str="李四";
        /**\u000d str="李四";*/
        //若是汉字 \u4f60 “你”不会在注释中被解析
        System.out.println(str);
        String s = "你";
    }
}
