package com.stream;

import org.junit.Test;

import java.util.*;
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
    public void test(){
        new Thread(()->System.out.println("线程运行...")).start();
    }

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
        //打印传入的 msg
        printMsg((s)-> System.out.println(s),"听朋友说「烟雨星空」公众号不仅文章好看，还免费送程序员福利，我心动了");
    }

    public void printMsg(Consumer<String> consumer,String msg){
        //消费型，只有传入参数，没有返回值
        consumer.accept(msg);
    }

    @Test
    public void test3(){
        //返回一个 0~99 的随机数
        Integer content = getContent(() -> new Random().nextInt(100));
        System.out.println(content);
    }

    public Integer getContent(Supplier<Integer> supplier){
        //供给型，传入参数为空，带返回值
        return supplier.get();
    }

    @Test
    public void test4(){
        //传入一个字符串，然后把它都转换成大写字母。
        System.out.println(transfer((str) -> str.toUpperCase(), "My wechat : mistyskys"));
    }

    public String transfer(Function<String,String> func,String str){
        // 函数型，传入一个参数，对其进行处理之后，返回一个结果
        return func.apply(str);
    }

    @Test
    public void test5(){
        //定义一个list，用来做筛选
        ArrayList<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("jerry");
        list.add("tom");
        //筛选出集合中，字符串长度大于 3 的，并加入到结果集。
        List<String> filterResult = filter((str) -> str.length() > 3, list);
        System.out.println(filterResult.toString());
    }

    public List<String> filter(Predicate<String> predicate, List<String> list){
        List<String> result = new ArrayList<>();
        for (String str : list) {
            // 断言型，传入一个参数，并返回true或者false。
            // 这里的逻辑是，若断言为真，则把当前的字符串加入到结果集中
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
