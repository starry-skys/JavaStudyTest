package com.map;

import java.util.HashMap;

/**
 *
 * @DATE 2019/10/17 17:42
 */
public class TestAbsent {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        String name = map.putIfAbsent("name", "");
        System.out.println(name);
        System.out.println(map.get("name"));
    }
}
