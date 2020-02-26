package com.designPrinciple.demeter;

/**
 * @Author zwb
 * @DATE 2019/12/19 17:00
 */
public class DeptManager {

    public void task(){
        System.out.println("部门领导发布任务");
        Employee employee = new Employee();
        employee.doTask();
    }
}
