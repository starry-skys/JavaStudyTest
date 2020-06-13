package com.designMode.factory.abstr;

import com.designMode.factory.simple.Car;

/**
 * @Author Stephen
 * @DATE 2019/12/23 16:08
 */
public class HighBenz implements Car {
    @Override
    public void getCar() {
        System.out.println("高配奔驰车");
    }
}
