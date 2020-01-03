package com.child;

import com.parent.Animal;

import java.util.Arrays;
import java.util.List;

/**
 * @Author wanbei
 * @DATE 2019/7/22 15:41
 */
public class Bird extends Animal {
    public static void main(String[] args) {
        Bird bird = new Bird();
        System.out.println(bird.id);
        System.out.println(bird.name);
//        System.out.printf(bird.color);
//        System.out.println(bird.age);

        Cat cat = new Cat();

        List<String> list = Arrays.asList("a", "b");
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            
        }
        for (int i = 0; i < list.size(); i++) {
            
        }
        for (String s : list) {

        }
    }
}
