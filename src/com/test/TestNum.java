package com.test;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @Author zwb
 * @DATE 2020/9/9 10:23
 */
public class TestNum {
    @Test
    public void test1() throws NoSuchFieldException, IllegalAccessException {
        Class cache = Integer.class.getDeclaredClasses()[0]; //1
        Field myCache = cache.getDeclaredField("cache"); //2
        myCache.setAccessible(true);//3

        Integer[] newCache = (Integer[]) myCache.get(cache); //4
        newCache[132] = newCache[133]; //5

        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b); //
    }
}
