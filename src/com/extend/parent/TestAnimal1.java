package com.extend.parent;

/**
 *
 * @DATE 2019/7/22 15:40
 */
public class TestAnimal1 {
    public static void main(String[] args) {
        Animal animal = new Animal(1,"animal1","black",3);
        System.out.println(animal.id);
        System.out.println(animal.name);
        System.out.println(animal.color);
//        System.out.println(animal.age);
    }
}


