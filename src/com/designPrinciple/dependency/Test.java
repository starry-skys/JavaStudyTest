package com.designPrinciple.dependency;

/**
 * @Author Stephen
 * @DATE 2019/12/19 11:09
 */
public class Test {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.study(new History());
        stu.study(new Geography());
    }
}
