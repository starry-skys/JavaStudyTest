package com.spi;

import java.util.ServiceLoader;

/**
 * @author Stephen
 * @date 2020/5/23 14:39
 */
public class JavaSpiTest {
    public static void main(String[] args) {
        ServiceLoader<Animal> loader = ServiceLoader.load(Animal.class);

        loader.forEach(Animal::eat);
//        Iterator<Animal> it = loader.iterator();
//        while (it.hasNext()){
//            Animal ani = it.next();
//            ani.eat();
//        }
    }
}
