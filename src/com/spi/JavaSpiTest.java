package com.spi;

import java.util.ServiceLoader;

/**
 * @author Stephen
 * @date 2020/5/23 14:39
 */
public class JavaSpiTest {
    public static void main(String[] args) {
        ServiceLoader<com.spi.Animal> loader = ServiceLoader.load(com.spi.Animal.class);

        loader.forEach(Animal::eat);
//        Iterator<Animal> it = loader.iterator();
//        while (it.hasNext()){
//            com.spi.Animal ani = it.next();
//            ani.eat();
//        }
    }
}
