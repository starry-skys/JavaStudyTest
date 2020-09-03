package com.stream.anno;

/**
 * @Author zwb
 * @DATE 2020/9/3 16:38
 */
public class AnnoTest {

    @MyRepeatableAnno("hello")
    @MyRepeatableAnno("world")
    public void show(@MyAnno("abc") String str){

    }
}
