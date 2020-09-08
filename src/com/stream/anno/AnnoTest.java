package com.stream.anno;

import org.junit.Test;

import java.util.List;

/**
 * @Author zwb
 * @DATE 2020/9/3 16:38
 */
public class AnnoTest {

    private @MyAnno("") Object object ;
    private List<@MyAnno("") String> list;

    @MyRepeatableAnno("hello")
    @MyRepeatableAnno("world")
    public void show(@MyAnno("abc") String str){

    }
    
    @Test
    public void test(){
        AnnoTest.class
        
    }
}
