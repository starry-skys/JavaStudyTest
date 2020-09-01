package com.designPrinciple.demeter;

/**
 * @Author Stephen
 * @DATE 2019/12/19 17:00
 */
public class Boss {
    private DeptManager deptMgr;

    public void setDeptMgr(DeptManager mgr){
        this.deptMgr = mgr;
    }

    public void task(){
        System.out.println("老板发布任务");
        deptMgr.task();
    }
}
