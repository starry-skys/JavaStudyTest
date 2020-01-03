package com.test.designMode.factory.abstr;

import com.test.designMode.factory.simple.Car;

/**
 * @Author zwb
 * @DATE 2019/12/23 16:09
 */
public class LowBenz implements Car {
    @Override
    public void getCar() {
        System.out.printf("低配奔驰车");
    }
}
