package com.designMode.factory.simple;

/**
 * @Author Stephen
 * @DATE 2019/12/23 15:05
 */
public class BenzCar implements Car {
    @Override
    public void getCar() {
        System.out.println("这是奔驰车");
    }
}
