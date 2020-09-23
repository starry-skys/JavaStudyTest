package com.test;

import java.util.UUID;

/**
 * @Author zwb
 * @DATE 2020/9/15 17:24
 */
public class TestNewObj {
    public static void main(String[] args) {
        Person person = new Person();
    }

    private static final class Person {
        String tid = UUID.randomUUID().toString();
    }
}
