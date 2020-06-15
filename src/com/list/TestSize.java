package com.list;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @DATE 2019/3/27 17:20
 */
public class TestSize {
    public static void main(String[] args) {
        List<String> item = new ArrayList<>(1);
        System.out.println(item.size());
        item.add("1");
        item.add("2");
        item.add("3");
        System.out.println("end");
//
////        System.out.println(item.size());
////        item.remove("2");
////        System.out.println(item);
////        System.out.println(item.size());
//        List<String> res = item.subList(1, 2);
//        System.out.println(res);

    }
}
