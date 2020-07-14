package com.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Stephen
 * @date 2020/6/14 16:37
 */
public class TestCHM {
    public static void main(String[] args) {

        Map<String, Integer> map = new ConcurrentHashMap<>(16);
        map.computeIfAbsent(
                "AaAa",
                key -> {
                    return map.computeIfAbsent(
                            "BBBB",
                            key2 -> 42);
                }
        );
    }

}
