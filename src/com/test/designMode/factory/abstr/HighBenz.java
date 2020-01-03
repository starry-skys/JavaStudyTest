package com.test.designMode.factory.abstr;

import com.test.designMode.factory.simple.Car;

/**
 * @Author zwb
 * @DATE 2019/12/23 16:08
 */
public class HighBenz implements Car {
    @Override
    public void getCar() {
        System.out.println("高配奔驰车");
    }
}
