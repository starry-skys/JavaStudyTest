package com.test.designMode.factory.simple;

/**
 * @Author zwb
 * @DATE 2019/12/23 15:04
 */
public class BMWCar implements Car {
    @Override
    public void getCar() {
        System.out.println("这是宝马车");
    }
}
