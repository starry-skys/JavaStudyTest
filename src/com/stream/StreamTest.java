package com.stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Stephen
 * @date 2020/9/3 23:29
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zhangzan");
        list.add("lisi");
        list.add("wangwu");
        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();
        stream.forEach(System.out::println);
        
        String[] arr = {"abc","aa","ef"};
        Stream<String> stream1 = Arrays.stream(arr);

        Stream<Integer> stream2 = Stream.of(10, 20, 30, 40, 50);
        stream2.forEach(System.out::println);

        Stream<Integer> generate = Stream.generate(() -> new Random().nextInt(100));
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 2);

        IntStream intStream = IntStream.of(10, 20, 30);
        IntStream rangeStream = IntStream.range(0, 10);
        IntStream rangeClosed = IntStream.rangeClosed(0, 10);
        rangeStream.forEach(System.out::println);
    }

    @Test
    public void test1(){
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("张三",3000));
        list.add(new Employee("李四",5000));
        list.add(new Employee("王五",4000));
        list.add(new Employee("赵六",4500));
        list.add(new Employee("赵六",4500));

        // filter，过滤出工资大于4000的员工
        list.stream()
            .filter((e) -> e.getSalary() > 4000)
            .forEach(System.out::println);

        System.out.println("===============");
        // limit，限定指定个数的元素
        list.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("===============");
        // skip，和 limit 正好相反，跳过前面指定个数的元素
        list.stream()
                .skip(3)
                .forEach(System.out::println);

        System.out.println("===============");
        // distinct，去重元素。注意自定义对象需要重写 equals 和 hashCode方法
        list.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("===============");
    }

    @Test
    public void test2(){
        int[] arr = {10,20,30,40,50};
        // map，映射。每个元素都乘以2
        Arrays.stream(arr)
                .map(e -> e * 2)
                .forEach(System.out::println);

        System.out.println("===============");
        //mapToInt,mapToDouble,mapToLong 用法都一样，不同的是返回类型分别是
        //IntStream,DoubleStream,LongStream.
        Arrays.stream(arr)
                .mapToDouble(e -> e * 2 )
                .forEach(System.out::println);

        System.out.println("===============");
        Arrays.stream(arr)
                .flatMap(e -> IntStream.of(e * 2))
                .forEach(System.out::println);
    }

    @Test
    public void test3(){
        String[] fruits = {"apple","orange","banana"};
        Stream.of(fruits).map((s) -> Stream.of(s.split("")))
                         .forEach(e -> e.forEach(System.out::print));

        System.out.println();
        Stream.of(fruits).map(s -> s.split(""))
                         .flatMap(e -> Stream.of(e))
                         .forEach(System.out::print);

        System.out.println();Stream.of(fruits).flatMap(s -> Stream.of(s.split("")))
                         .collect(Collectors.toList())
                         .forEach(System.out::print);

    }

    @Test
    public void test4(){
        String[] arr = {"abc","aa","ef"};
        //默认升序（字典升序）
        Stream.of(arr).sorted().forEach(System.out::println);
        System.out.println("=====");
        //自定义排序，字典降序
        Stream.of(arr).sorted((s1,s2) -> s2.compareTo(s1))
                      .forEach(System.out::println);
    }

    @Test
    public void test5(){
        Integer[] arr = {1,2,3,4,5,6};
        Integer res1 = Stream.of(arr).reduce((x, y) -> x + y).get();
        System.out.println(res1);

        Integer res2 = Stream.of(arr).reduce(10,(x, y) -> x + y);
        System.out.println(res2);

        ArrayList<Integer> res = Stream.of(arr).reduce(Lists.newArrayList(0),
                (l, e) -> {
                    l.add(e);
                    return l;
                },
                (l, c) -> {
                    System.out.println("combiner");
                    l.addAll(c);
                    return l;
                });
        System.out.println(res);

        Set<Integer> res3 = Stream.of(1, 2, 3, 4).parallel().reduce(Collections.synchronizedSet(Sets.newHashSet(10)),
                (l, e) -> {
                    l.add(e);
                    return l;
                },
                (l, c) -> {
                    l.addAll(c);
                    return l;
                });
        System.out.println(res3);

        AtomicInteger c = new AtomicInteger(0);
        Integer res4 = Stream.of(1,2,3,4).parallel().reduce(1,
                (s,e) -> s + e,
                (sum, s) -> {
                    System.out.println(s);c.getAndIncrement(); return sum + s;});
        System.out.println(c);
        System.out.println(res4);

        AtomicInteger count = new AtomicInteger(0);
        int length = 100;
        Integer[] arr1 = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr1[i] = i + 1;
        }
        Integer res5 = Stream.of(arr1).parallel().reduce(0,
                (s,e) -> s + e,
                (sum, s) -> {count.getAndIncrement(); return sum + s;});
        System.out.println(count.get());
        System.out.println(res5);
    }

    @Test
    public void test6() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("张三", 3000));
        list.add(new Employee("李四", 5000));
        list.add(new Employee("王五", 4000));
        list.add(new Employee("赵六", 4500));

        //把所有员工的姓名收集到list中
        list.stream()
                .map(Employee::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //求出所有员工的薪资平均值
        Double average = list.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(average);

    }

}
