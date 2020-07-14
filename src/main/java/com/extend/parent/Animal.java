package com.extend.parent;

/**
 *
 * @DATE 2019/7/22 15:37
 */
public class Animal {
    public int id = 0;

    static protected String name = "animal";

    String color = "white";

    private int age = 2;

    public Animal(int id, String name, String color, int age) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Animal() {

    }

    public void printName(){
        System.out.println("父类:" + this.name);
    }
}
