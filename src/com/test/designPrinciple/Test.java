package com.test.designPrinciple;

/**
 * @Author zwb
 * @DATE 2019/12/18 14:37
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.eat(new Herbivore(),"牛");
        t.eat(new Carnivore(),"老虎");
    }

    public void eat(Animal animal,String name){
        System.out.println(name + animal.eat());
    }

    public void eat(String name){
        System.out.println(name + "吃草");
    }
}
