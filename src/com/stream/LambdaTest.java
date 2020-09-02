package com.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author zwb
 * @DATE 2020/9/2 16:04
 */
public class LambdaTest {
    @Test
    public void test1(){

        TreeMap<String, String> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        treeMap.put("aaa","aaa");
        treeMap.put("abcd","abcd");
        treeMap.put("bb","bb");
        System.out.println(treeMap);

        TreeMap<String, String> treeMap1 = new TreeMap<>((o1, o2) -> o1.length() - o2.length());
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
        MyFunc.method3();
    }
}
