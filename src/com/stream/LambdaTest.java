package com.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

/**
 * @Author zwb
 * @DATE 2020/9/2 16:04
 */
public class LambdaTest {
    @Test
    public void test1(){

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("abcd");
        list.add("bb");

        Collections.sort(list,(o1,o2)-> o2.compareTo(o1));
        Collections.sort(list,String::compareTo);
        System.out.println(list);
    }

    @Test
    public void test2(){
        printMsg((s)-> System.out.println(s),"听朋友说「烟雨星空」公众号不仅文章好看，还免费送程序员福利，我心动了");
    }

    public void printMsg(Consumer<String> consumer,String msg){
        consumer.accept(msg);
    }

    @Test
    public void test3(){
        System.out.println(getContent(() -> "我是内容"));
    }

    public String getContent(Supplier<String> supplier){
        return supplier.get();
    }

    @Test
    public void test4(){
        System.out.println(transfer((str) -> str.toUpperCase(), "My wechat : mistyskys"));
    }

    public String transfer(Function<String,String> func,String str){
        return func.apply(str);
    }

    @Test
    public void test5(){
        ArrayList<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("jerry");
        list.add("tom");
        List<String> filterResult = filter((str) -> str.length() > 3, list);
        System.out.println(filterResult.toString());
    }

    public List<String> filter(Predicate<String> predicate, List<String> list){
        List<String> result = new ArrayList<>();
        for (String str : list) {
            if(predicate.test(str)){
                result.add(str);
            }
        }
        return result;
    }

    @Test
    public void test6(){
        int res = compareTo(String::compareTo, "abc", "aa");
        System.out.println(res);
    }

    public int compareTo(ToIntBiFunction<String,String> func,String s1, String s2){
        return func.applyAsInt(s1,s2);
    }
}
