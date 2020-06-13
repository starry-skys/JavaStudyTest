package com.extend.child;

import com.extend.parent.Animal;

/**
 *
 * @DATE 2019/7/22 15:53
 */
public class TestAnimal2 {
    public static void main(String[] args) {
        Animal animal = new Animal(1,"animal1","black",3);
        System.out.println(animal.id);
//        System.out.println(animal.name);
//        System.out.println(animal.color);
//        System.out.println(animal.age);
    }
}
