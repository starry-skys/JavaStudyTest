package com.stream.refer;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.ToIntBiFunction;

/**
 * @Author zwb
 * @DATE 2020/9/3 11:26
 */
public class ReferTest {
    @Test
    public void test1(){
        String[] arr = new String[]{"zhangsan","lisi"};
        Arrays.asList(arr).forEach((s)-> System.out.println(s));
        Arrays.asList(arr).forEach(System.out::println);
    }

    @Test
    public void test6(){
        int res = compareTo(String::compareTo, "abc", "aa");
        System.out.println(res);
    }

    public int compareTo(ToIntBiFunction<String,String> func, String s1, String s2){
        return func.applyAsInt(s1,s2);
    }
}
