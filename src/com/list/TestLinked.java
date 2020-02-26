package com.list;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author wanbei
 * @DATE 2019/3/29 14:45
 */
public class TestLinked {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(5);
        list.add(1);
        list.addAll(1, Arrays.asList(2,3,4));
        list.remove(new Integer(1));
        System.out.println(list);
    }
}
