package com.test.designPrinciple.dependency;

/**
 * @Author zwb
 * @DATE 2019/12/19 11:09
 */
public class Student {
    public void study(IKnowledge iKnowledge){
        System.out.println("学习" + iKnowledge.getKnowledge());
    }
}
