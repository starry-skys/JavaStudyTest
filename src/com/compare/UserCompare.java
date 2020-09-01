package com.compare;

import java.util.Comparator;

/**
 * @Author Stephen
 * @DATE 2020/1/6 15:47
 */
public class UserCompare implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getAge() - o2.getAge();
    }
}
