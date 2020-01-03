package com.test.designPrinciple.demeter;

/**
 * @Author zwb
 * @DATE 2019/12/19 16:42
 */
public class TestD {
    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.setDeptMgr(new DeptManager());
        boss.task();
    }
}
