package com.test.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wanbei
 * @DATE 2018/9/11 15:44
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> item = new ArrayList<>();
        item.add("part1");
        item.add("2");
        item.add("3");
        List<String> item2 = new ArrayList<>();
        item2.add("part2");
        item2.add("4");
        item2.add("6");
        List<List> list = new ArrayList<>();
        list.add(item);
        list.add(item2);
        System.out.println(list);

    }
}
