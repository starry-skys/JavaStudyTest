package com.extend.child;

import com.extend.parent.Animal;

/**
 *
 * @DATE 2019/7/22 15:41
 */
public class Bird extends Animal {
    public static void main(String[] args) {
        Bird bird = new Bird();
        System.out.println(bird.id);
        System.out.println(bird.name);
//        System.out.printf(bird.color);
//        System.out.println(bird.age);

        Animal animal = new Animal();

    }

    public void printName() {
        System.out.println("子类:" + this.name);
    }
}
