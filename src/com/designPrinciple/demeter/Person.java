package com.designPrinciple.demeter;

/**
 * @Author Stephen
 * @DATE 2019/12/19 16:40
 */
public class Person {
    private Computer c;

    public void setComputer(Computer c){
        this.c = c;
    }

    public void playGame(){
        System.out.println("开始玩游戏");
        c.executeCmd();
        c.loadMemory();
        c.graphics();
        c.sounds();
    }
}
