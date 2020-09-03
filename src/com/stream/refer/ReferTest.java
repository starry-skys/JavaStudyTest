package com.stream.refer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Author zwb
 * @DATE 2020/9/3 11:26
 */
public class ReferTest {
    public static void main(String[] args) {
        //函数式接口的抽象方法的参数列表和返回值类型，必须与方法引用对应的方法参数列表和返回值类型保持一致(情况3除外，比较特殊)。
        //======= 1.对象::实例方法 =========
        // lambda 表达式
        Consumer consumer1 = (s) -> System.out.println(s);
        consumer1.accept("hello world");
        //方法引用。Consumer的accept方法，和System.out的println方法结构一样，
        //都是传入一个参数，无返回值。故可以用方法引用。
        Consumer consumer2 = System.out::println;
        consumer2.accept("hello java");

        //======= 2.类::静态方法 =========
        Integer[] arr = new Integer[]{12,20,15};
        List<Integer> list = Arrays.asList(arr);
        // lambda 表达式
        Comparator<Integer> com1 = (o1, o2) -> Integer.compare(o1, o2);
        Collections.sort(list,com1);
        //方法引用。Comparator的compare方法，和Integer的compare静态方法结构一样，
        //都是传入两个参数，返回一个int值，故可以用方法引用。
        Comparator<Integer> com2 = Integer::compare;
        Collections.sort(list,com2);

        //======= 3.类::实例方法 =========
        // lambda表达式
        Comparator<Integer> com3 = (o1, o2) -> o1.compareTo(o2);
        //方法引用。这种形式比较特殊，(o1, o2) -> o1.compareTo(o2) ，
        //当第一个参数o1为调用对象，且第二个参数o2为需要引用方法的参数时，才可用这种方式。
        Comparator<Integer> com4 = Integer::compareTo;

        //======= 4.类::new =========
        // lambda表达式
        Supplier<String> supplier1 = () -> new String();
        //方法引用。这个就比较简单了，就是类的构造器引用，一般用于创建对象。
        Supplier<String> supplier2 = String::new;
    }
}
