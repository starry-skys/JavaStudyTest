package com.designMode.factory.simple;

/**
 * @Author Stephen
 * @DATE 2019/12/23 15:06
 */
public class FTest {
    public static void main(String[] args) {
        DefaultFactory factory = new DefaultFactory();
        Car car = factory.produce("bmw");
        car.getCar();

        Car benz = factory.produce("benz");
        benz.getCar();
    }
}
