package com.compare;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author Stephen
 * @DATE 2020/1/6 15:18
 */
public class CmpTest {
    public static void main(String[] args) {

        User user1 = new User(20, "李四");
        User user2 = new User(18, "张三");

//        int res = user1.compareTo(user2);
//        System.out.println(res);
        User user3 = new User(23, "王五");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        System.out.println("排序前");
        for (User user : userList) {
            System.out.println(user.getAge()+":"+user.getName());
        }
        Collections.sort(userList, new UserCompare());
//        Collections.sort(userList);
        System.out.println("排序后");
        for (User user : userList) {
            System.out.println(user.getAge()+":"+user.getName());
        }
    }
}
