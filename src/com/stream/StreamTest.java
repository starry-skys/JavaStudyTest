package com.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
}
