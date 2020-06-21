package com.map;

import java.util.HashMap;

/**
 * @author Stephen
 * @date 2020/6/21 10:04
 */
public class TestHashCode {
    public static void main(String[] args) {
        User user = new User("zhangsan", 20);

        HashMap<User, Integer> map = new HashMap<>();
        map.put(user,90);
        System.out.println(map.get(user));
        user.setAge(18);
        System.out.println(map.get(user));
    }
}
